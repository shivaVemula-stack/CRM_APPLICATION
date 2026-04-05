import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtility {
static {
    try{
        //load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");


    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    public static Connection getConnection() throws SQLException {
        //Establish the connection

        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "myPwd@26";
       return DriverManager.getConnection(url, user, password);
    }
    public static void closeTheConnection(Connection connection, Statement statement) throws SQLException {
        statement.close();
        connection.close();
    }
}
