package cn.saya.framework.excel.poi.in;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.junit.Test;
import org.apache.log4j.Logger;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadeExcel {

    private static final Logger LOGGER = Logger.getLogger(ReadeExcel.class);

    @Test
    /**
     * 解析文件
     */
    public void reade() throws Exception
    {
        LOGGER.error("程序执行错误");
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

}
