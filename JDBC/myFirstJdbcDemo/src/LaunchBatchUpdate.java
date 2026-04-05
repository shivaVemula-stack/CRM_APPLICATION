
import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class LaunchBatchUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStmt = null;

        try {
            connection = jdbcUtility.getConnection();


            //creating Statement
//            statement = connection.createStatement();



            //execute query
            String query= "UPDATE studentinfo set age = ? where id = ?";
            preparedStmt = connection.prepareStatement(query);
            ;

            preparedStmt.setInt(1,99);
            preparedStmt.setInt(2,1);
            preparedStmt.addBatch();

            preparedStmt.setInt(1,88);
            preparedStmt.setInt(2,2);
            preparedStmt.addBatch();


            preparedStmt.setInt(1,96);
            preparedStmt.setInt(2,5);
            preparedStmt.addBatch();


            preparedStmt.setInt(1,69);
            preparedStmt.setInt(2,6);
            preparedStmt.addBatch();


            preparedStmt.executeBatch();
            System.out.println("check your DB to see the changes");
            //process the result
//            if (rowAffected == 0) {
//                System.out.println("Unable to insert the Data");
//
//
//            } else {
//                System.out.println("Data inserted Successfully");
//
//            }

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
