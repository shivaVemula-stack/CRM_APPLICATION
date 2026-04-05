
import java.sql.*;

import static java.lang.Class.forName;

public class LaunchAppQuery3 {
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
        String sqlQuery = "update studentinfo set age=44 where id =3";

        boolean queryStatus = statement.execute(sqlQuery);
        //process the result
        if (queryStatus){
            System.out.println("If Block");
            //select
            ResultSet result = statement.getResultSet();
            while (result.next()){
                System.out.println(result.getInt(1)+" "+ result.getString(2)+" "+result.getInt(3)+" "+result.getString(4));
            }
        }else {
            System.out.println("Else Block");

            //inser,delete,update
            int rows = statement.getUpdateCount();
            if (rows == 0){
                System.out.println("Operation failed");
            }else {
                System.out.println("Operation Successful");
            }
        }
        //close the resources
        statement.close();
        connection.close();


    }


}
