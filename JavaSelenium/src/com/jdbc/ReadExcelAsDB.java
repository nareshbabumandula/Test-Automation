package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadExcelAsDB {

    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query = "select TestScript from [TS 360 Scripts$]";

        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:;Driver={Microsoft Excel Driver(*.xlsx)};DBQ=D://TS 360 Script with Count.xlsx");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString("TestScript"));
            }
            con.close();
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
