package cn.saya.framework.excel.jxl.out;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CreateExcel {

    @Test
    /**
     * 输出文件
     */
    public void createExcel() throws Exception {
        //第一行字段名
        String[] title = {"id","user","type","date"};
        String excelDir = System.getProperty("user.dir") + "\\log\\create.xls";
        File file = new File(excelDir);
        file.createNewFile();
        //创建工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        //创建工作表
        WritableSheet sheet = workbook.createSheet("工作表1",0);
        //单元格
        Label label = null;
        for(int i = 0;i < title.length;i++)
        {
            label = new Label(i,0,title[i]);
            sheet.addCell(label);//添加到表中
        }
        for(int i = 1;i < 10;i++)
        {
            //编号
            label = new Label(0,i,Integer.toString(i));
            sheet.addCell(label);
            //用户
            label = new Label(1,i,"Pandora");
            sheet.addCell(label);
            //类别
            label = new Label(2,i,"Ox001");
            sheet.addCell(label);
            //日期
            label = new Label(3,i,"2018-01-29 12:12:12");
            sheet.addCell(label);
        }
        //写入到表格中
        workbook.write();
        //关闭流
        workbook.close();
    }

}

