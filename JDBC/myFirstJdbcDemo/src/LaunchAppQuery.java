
import java.sql.*;

import static java.lang.Class.forName;

public class LaunchAppQuery {
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
        String sqlQuery = "SELECT * FROM studentinfo";
        ResultSet rs = statement.executeQuery(sqlQuery);
        System.out.println(rs);


        //process the result
        while(rs.next()){
//            int id = rs.getInt(1);
            int id = rs.getInt("id");

//            String name = rs.getString(2);
            String name = rs.getString("name");

//            int age = rs.getInt(3);
            int age = rs.getInt("age");


//            String city = rs.getString(4);
            String city = rs.getString("city");

            System.out.println(id +" "+ name+ " "+ age+" "+ city);
        }

        //close the resources
        rs.close();
        statement.close();
        connection.close();


    }


}
