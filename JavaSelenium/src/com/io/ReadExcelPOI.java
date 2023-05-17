package com.io;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelPOI {
	
	public void ReadExcelMethods() throws BiffException, IOException {
		
		String strFilepath = "./files/Data.xlsx";
		FileInputStream fis = new FileInputStream(strFilepath);
		//HSSFWorkbook wb = new HSSFWorkbook(fis); // Create workbook class object
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//HSSFSheet sh = wb.getSheet("Login"); // To access the Login sheet
		XSSFSheet sh = wb.getSheet("Login");
		//HSSFSheet sh1 = wb.getSheet("Registration"); // To access the Registration sheet
		XSSFSheet sh1 = wb.getSheet("Registration"); // To access the Registration sheet
		System.out.println(sh.getSheetName());
		System.out.println(sh1.getSheetName());
		
		int nRows = sh.getLastRowNum()-sh.getFirstRowNum();
	
		System.out.println("No of rows in login sheet are : " + nRows);
		
		int noOfColumns = sh.getRow(0).getPhysicalNumberOfCells();
		int noColumns = sh.getRow(0).getLastCellNum();
		System.out.println("No of columns in login sheet are : " + noOfColumns);
		System.out.println("No of columns in login sheet are : " + noColumns);
		
		//Iterate through rows
		for(int i=0; i<nRows+1; i++) {
			Row row = sh.getRow(i);
			//Iterate through columns
			for(int j=0; j<row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
		wb.close();
	}

	public static void main(String[] args) throws BiffException, IOException {
		ReadExcelPOI read = new ReadExcelPOI();
		read.ReadExcelMethods();

	}

}
