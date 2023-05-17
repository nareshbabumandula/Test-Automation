package com.io;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelAPITest
{
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;

    public ExcelAPITest(String xlFilePath) throws Exception
    {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }

    public String getCellData(String sheetName, String colName, int rowNum)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }

            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);

            if(cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        }
    }
}
