package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJdbcTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Load the driver class
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Establish the Connection b/w JavaPgm to Oracle DbŚ
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

        //Create the Statement Object to Pass Sqlquery to db server
        Statement st=con.createStatement();
        int a=st.executeUpdate("drop table hospital");
        System.out.println(a);
        //Process or execute the sql query which is passing to db
        int i=st.executeUpdate("create table hospital(id int,name char(10))");
        System.out.println(i);
        st.executeQuery("insert into hospital values(111, 'KIMS')");
        int j=st.executeUpdate("update hospital set id=222 where id=111");
        System.out.println(i);
        int k=st.executeUpdate("delete from hospital where id=222");
        System.out.println(k);


        //Close the Connections
        st.close();
        con.close();

    }

}