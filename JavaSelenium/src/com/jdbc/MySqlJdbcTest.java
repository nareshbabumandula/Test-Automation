package com.jdbc;

import java.sql.*;

public class MySqlJdbcTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * forName() The most common approach to register a driver is to use Java's Class. forName() method,
         * to dynamically load the driver's class file into memory, which automatically registers it.
         * This method is preferable because it allows you to make the driver registration configurable and portable.
         * - When you have loaded a driver, it is available for making a connection with a DBMS.
         * - It is used to create an instance of a driver and register it with the DriverManager.
         * - Before connecting to the database we need to load a driver.
         * - Whenever the code tries to open a connection we get a no driver available SQLException being thrown.
         * - It is mostly caused by the driver not being in the class path or the value in the parameter is not correct.
         */
        //Load the driver class
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the Connection b/w JavaPgm to MySql
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","root");
        System.out.println("Database connection status is : " + con.isClosed());
        ResultSet rs = null;

        //Create the Statement Object to Pass Sqlquery to db server
        Statement st=con.createStatement(); //Creates a Statement object for sending SQL statements to the database
        int a = st.executeUpdate("drop table Customers");
        System.out.println(a);
        //Process or execute the sql query which is passing to db
        int i=st.executeUpdate("create table Customers(id int,name char(10), address varchar(50))");
        System.out.println(i);
        int j = st.executeUpdate("insert into Customers values(111, 'Naresh', 'Kphb'), (333, 'Kalpana', 'Bangalore')");
        System.out.println(j);
        rs = st.executeQuery("select * from Customers");

        while(rs.next()){
            int custID = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("Address");
            System.out.println(custID + " " + name + " " + address);
        }

        int k=st.executeUpdate("update Customers set id=222 where id=111");
        System.out.println(k);
        int l=st.executeUpdate("delete from Customers where id=222");
        System.out.println(l);

        //Close the Connections
        st.close();
        con.close();

    }

}

