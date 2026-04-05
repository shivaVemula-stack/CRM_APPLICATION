
import java.sql.*;

import static java.lang.Class.forName;

public class LaunchAppQuery2 {
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
        String sqlQuery = "delete from studentinfo where id=2";
        int affectedRows = statement.executeUpdate(sqlQuery);

        //process the result
        if (affectedRows == 0){
            System.out.println("Deletion was unsuccsseful");
        }else {
            System.out.println("Record is deleted");
        }
        //close the resources
        statement.close();
        connection.close();


    }


}
