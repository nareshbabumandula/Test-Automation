package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcel {
	
	public void ReadExcelMethods() throws BiffException, IOException, WriteException {
		
		String strFilepath = "./Files/Automation Report.xls";
		
		WritableWorkbook wb = Workbook.createWorkbook(new File(strFilepath));
		WritableSheet ws = wb.createSheet("Execution Results", 1);
		{
			Label label = new Label(0,0,"Automation");
			Label label1 = new Label(1,0,"Results");
			ws.addCell(label);
			ws.addCell(label1);
		}
		wb.write();
		wb.close();
	}

	public static void main(String[] args) throws BiffException, IOException, WriteException {
		WriteExcel read = new WriteExcel();
		read.ReadExcelMethods();

	}

}
