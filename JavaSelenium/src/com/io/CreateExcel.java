package com.io;

import java.io.FileOutputStream;

public class CreateExcel {
    public static void main(String[]args)
    {
        try
        {
            String filename = "C:\\Users\\Anubhav\\Desktop\\CustomersDetail.xlsx";
            FileOutputStream fileOut = new FileOutputStream(filename);
            fileOut.close();
            System.out.println("Excel file has been generated successfully.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
