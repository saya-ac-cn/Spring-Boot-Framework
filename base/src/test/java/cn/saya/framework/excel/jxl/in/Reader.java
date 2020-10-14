package cn.saya.framework.excel.jxl.in;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;

import java.io.File;

public class Reader {

    @Test
    /**
     * 读取表格数据
     */
    public void readerExcel() throws Exception{
        //创建workbook对象
        Workbook workbook = Workbook.getWorkbook(new File(System.getProperty("user.dir") + "\\log\\create.xls"));
        //获取指定工作表
        Sheet sheet = workbook.getSheet(0);
        //获取数据
        for(int i = 0;i < sheet.getRows();i++)
        {
            for (int j = 0;j < sheet.getColumns();j++)
            {
                Cell cell = sheet.getCell(j,i);//j列，i行
                System.out.print(cell.getContents() + " ");
            }
            //换行
            System.out.println();
        }
    }

}
