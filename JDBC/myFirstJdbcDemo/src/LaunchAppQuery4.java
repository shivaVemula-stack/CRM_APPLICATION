
import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class LaunchAppQuery4 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStmt = null;

        try {
                connection = jdbcUtility.getConnection();


            //creating Statement
//            statement = connection.createStatement();



            //execute query
            String query= "INSERT INTO studentinfo(id,name,age,city) VALUES(?,?,?,?)";
            preparedStmt = connection.prepareStatement(query);

            System.out.println("Enter the Following Details to be strored In DB");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Your ID");
            Integer id = scan.nextInt();
            System.out.println("Enter Your name");
            String name = scan.next();
            System.out.println("Enter your Age");
            Integer age = scan.nextInt();
            System.out.println("Enter your City");
            String city = scan.next();

            preparedStmt.setInt(1,id);
            preparedStmt.setString(2,name);
            preparedStmt.setInt(3,age);
            preparedStmt.setString(4,city);


            int rowAffected = preparedStmt.executeUpdate();
            //process the result
            if (rowAffected == 0) {
                System.out.println("Unable to insert the Data");


            } else {
                System.out.println("Data inserted Successfully");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception exe) {
            exe.printStackTrace();
        } finally {
            //close the resources
            try {
                jdbcUtility.closeTheConnection(connection,preparedStmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
