package cn.saya.framework.excel.poi.out;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

public class CreateExcel {

    @Test
    /**
     * 创建文件
     */
    public void out() throws Exception
    {
        //第一行字段名
        String[] title = {"id","user","type","date"};
        //创建Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建Excel工作表
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
        //插入第二行字段名
        for(int i = 0;i < title.length;i++)
        {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //插入数据
        for(int i = 1;i <= 10;i++)
        {
            HSSFRow nextrow = sheet.createRow(i);
            //第一列
            HSSFCell dataCell = nextrow.createCell(0);
            dataCell.setCellValue(i);
            //第二列
            dataCell = nextrow.createCell(1);
            dataCell.setCellValue("Pandora");
            //第三列
            dataCell = nextrow.createCell(2);
            dataCell.setCellValue("Ox001");
            //第四列
            dataCell = nextrow.createCell(3);
            dataCell.setCellValue("2018-01-29 12:12:12");
        }
        //创建文件
        File file = new File(System.getProperty("user.dir") + "\\log\\create.xls");
        file.createNewFile();
        FileOutputStream stream = FileUtils.openOutputStream(file);
        workbook.write(stream);
        stream.close();
    }

}
