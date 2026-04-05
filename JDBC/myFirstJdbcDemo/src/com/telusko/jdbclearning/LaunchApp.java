package com.telusko.jdbclearning;
import java.sql.*;

import static java.lang.Class.forName;

public class LaunchApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //load and register the driver

        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the connection

        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "myPwd@26";
        Connection connection = DriverManager.getConnection(url, user, password);

        //creating Statement
        Statement statement = connection.createStatement();

        //execute query
//        String sqlQuery = "INSERT INTO studentinfo(id,name,age,city) VALUES(5,'rajesh',29,'Bombay')";
        String sqlQuery = "UPDATE studentinfo set age=24 where id = 2";

        int rowAffected = statement.executeUpdate(sqlQuery);
        //process the result
        if (rowAffected == 0){
//            System.out.println("Unable to insert the Data");
            System.out.println("Updation Failed");

        }else {
//            System.out.println("Data inserted Successfully");
            System.out.println("Update Successfull");

        }
        //close the resources
        statement.close();
        connection.close();


    }


}
