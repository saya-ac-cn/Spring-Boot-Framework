package cn.saya.framework.excel.poi.in;

import cn.saya.framework.api.entity.ExcelLineEntity;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadeExcel {

    private static final Logger logger = Logger.getLogger(ReadeExcel.class);

    @Test
    /**
     * 解析文件
     */
    public void reade() throws Exception
    {
        //解析文件
        File file = new File(System.getProperty("user.dir") + "\\log\\create.xls");
        //读取Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
        //读取Excel工作表
        HSSFSheet sheet = workbook.getSheetAt(0);//读取第一个工作表
        int firstRowNum = 0;//第一行
        int lastRowNum = sheet.getLastRowNum();//获取最后一行行号
        for(int i = firstRowNum;i <= lastRowNum;i++)
        {
            HSSFRow row = sheet.getRow(i);//当前行
            //获取当前行的最后一列列号
            int lastCellNum = row.getLastCellNum();
            for(int j = 0;j < lastCellNum;j++)
            {
                HSSFCell cell = row.getCell(j);
                String value = null;
                //根据单元格数据类型自动判断
                // 判断当前Cell的Type
                switch (cell.getCellType()) {
                    // 如果当前Cell的Type为NUMERIC
                    case HSSFCell.CELL_TYPE_NUMERIC: {
                        short format = cell.getCellStyle().getDataFormat();
                        if(format == 14 || format == 31 || format == 57 || format == 58){   //excel中的时间格式
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
                            value = sdf.format(date);
                        }
                        // 判断当前的cell是否为Date
                        else if (HSSFDateUtil.isCellDateFormatted(cell)) {  //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                            // 如果是Date类型则，取得该Cell的Date值           // 对2014-02-02格式识别不出是日期格式
                            Date date = cell.getDateCellValue();
                            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                            value = formater.format(date);
                        } else { // 如果是纯数字
                            // 取得当前Cell的数值
                            value = NumberToTextConverter.toText(cell.getNumericCellValue());
                        }
                        break;
                    }
                    // 如果当前Cell的Type为STRIN
                    case HSSFCell.CELL_TYPE_STRING:
                        // 取得当前的Cell字符串
                        value = cell.getStringCellValue().replaceAll("'", "''");
                        break;
                    case  HSSFCell.CELL_TYPE_BLANK:
                        value = null;
                        break;
                    // 默认的Cell值
                    default:{
                        value = " ";
                    }
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /**
     * 预处理时间格式
     * @Title: preDate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param
     * @return String
     * @throws
     */
    protected String preDate(HSSFCell cell) {
        short format = cell.getCellStyle().getDataFormat();
        String dateString = null;
        if(format == 14 || format == 31 || format == 57 || format == 58){   //excel中的时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
            dateString = sdf.format(date);
        }
        return dateString;
    }


    /**
     * 读取每一行数据
     * @Title: readLine
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param
     * @return void
     * @throws
     */
    @Test
    public void readLine() throws Exception
    {
        List<ExcelLineEntity> listExcel = new ArrayList<>();
        // 解析文件
        File file = new File(System.getProperty("user.dir") + File.separator +"src"+ File.separator +"main"+ File.separator +"resources"+ File.separator +"modify.xls");
        // 读取Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
        // 读取Excel工作表
        HSSFSheet sheet = workbook.getSheetAt(0);//读取第一个工作表
        int firstRowNum = 1;//第一行
        int lastRowNum = sheet.getLastRowNum();//获取最后一行行号
        // 遍历每一行
        for(int i = firstRowNum;i <= lastRowNum;i++)
        {
            HSSFRow row = sheet.getRow(i);//当前行
            ExcelLineEntity line = new ExcelLineEntity();

            HSSFCell cell = row.getCell(0);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，设备编号为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setDeviceId(Long.valueOf(cell.getStringCellValue().trim()));
            }

            cell = row.getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，连锁名为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setChainName(cell.getStringCellValue().trim());
            }

            cell = row.getCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，药店名为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setStoreName(cell.getStringCellValue().trim());
            }

            cell = row.getCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，单价为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setPrice(Double.valueOf(cell.getStringCellValue().trim()));
            }

            cell = row.getCell(4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，状态为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setStatus(Integer.valueOf(cell.getStringCellValue().trim()));
            }

            cell = row.getCell(5);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，Mac为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setMacId(cell.getStringCellValue().trim());
            }

            cell = row.getCell(6);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，实收款为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setRealReceivables(Double.valueOf(cell.getStringCellValue().trim()));
            }

            cell = row.getCell(7);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            if(preDate(cell) == null)
            {
                logger.error("第" + (i+1) + "行数据中，缴费时间为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setChargeTime(preDate(cell));
            }

            cell = row.getCell(8);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，汇款单号为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setFlowId(Long.valueOf(cell.getStringCellValue().trim()));
            }

            cell = row.getCell(9);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            if(preDate(cell) == null)
            {
                logger.error("第" + (i+1) + "行数据中，汇款日期为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setRemittanceTime(preDate(cell));
            }

            cell = row.getCell(10);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            logger.error("asd:"+cell.getStringCellValue().trim());
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，汇款人为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setRemitter(cell.getStringCellValue().trim());
            }

            cell = row.getCell(11);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，汇款总金额	为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setRemittanceTotal(Double.valueOf(cell.getStringCellValue().trim()));
            }

            cell = row.getCell(12);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            if(StringUtils.isEmpty(cell.getStringCellValue()))
            {
                logger.error("第" + (i+1) + "行数据中，客户编码为空！该行数据拒绝修改！");
                continue;
            }
            else
            {
                line.setCustCode(cell.getStringCellValue().trim());
            }
            listExcel.add(line);
        }
        logger.error(JSON.toJSONString(listExcel));
        workbook.close();
    }

}
