package com.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelHashmap {
    @Test public void getcelldata() throws IOException {

        FileInputStream file = new FileInputStream("./files/Data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sh = wb.getSheet("Login");

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            int key = (int)sh.getRow(r).getCell(0).getNumericCellValue();
            String value = sh.getRow(r).getCell(1).getStringCellValue();
            map.put(key, value);
        }

        // Displaying HashMap
        Iterator<Entry<Integer, String> > new_Iterator = map.entrySet().iterator();

        while (new_Iterator.hasNext()) {
            Map.Entry<Integer, String> new_Map= (Map.Entry<Integer, String>) new_Iterator.next();
            System.out.println(new_Map.getKey() + "|" + new_Map.getValue());
        }
        wb.close();
        file.close();
    }
}