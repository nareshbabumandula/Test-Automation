package com.io;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcel {
	
	public void ReadExcelMethods() throws BiffException, IOException {
		
		String strFilepath = "./files/Data.xls";
		FileInputStream fis = new FileInputStream(strFilepath);
		Workbook wb = Workbook.getWorkbook(fis);
	
		Sheet sh = wb.getSheet(0); // To access the Sheet1
		Sheet sh1 = wb.getSheet(1); // To access the Sheet2
		System.out.println(sh.getName());
		System.out.println(sh1.getName());
		
		int nRows = sh.getRows(); // To get row count
		int nRow = sh1.getRows(); // To get row count
		
		System.out.println("No of rows in " +  sh.getName() + " sheet are : " + nRows);
		System.out.println("No of rows in " +  sh1.getName() + " sheet are : " + nRow);
		
		int nColumns = sh.getColumns(); // To get column count
		int nColumn = sh1.getColumns(); // To get column count
		System.out.println("No of columns in " +  sh.getName() + " sheet are : " + nColumns);
		System.out.println("No of columns in " +  sh1.getName() + " sheet are : " + nColumn);
		
		for (int row = 0; row < nRows; row++) {
			for (int col = 0; col < nColumns; col++) {
				String celldata = sh.getCell(col, row).getContents();
				System.out.println(celldata);
			}
		}
				
		wb.close();
	}

	public static void main(String[] args) throws BiffException, IOException {
		ReadExcel read = new ReadExcel();
		read.ReadExcelMethods();

	}

}
