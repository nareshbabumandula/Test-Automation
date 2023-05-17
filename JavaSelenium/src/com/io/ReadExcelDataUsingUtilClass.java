package com.io;

public class ReadExcelDataUsingUtilClass {

    public static void main(String args[]) throws Exception
    {
        ExcelAPITest eat = new ExcelAPITest("./files/Data.xlsx");
        System.out.println(eat.getCellData("Login","URL",2));
        System.out.println(eat.getCellData("Login","USERNAME",2));
        System.out.println(eat.getCellData("Login","PASSWORD",2));
        System.out.println(eat.getCellData("Login","TYPE",2));
    }
}
