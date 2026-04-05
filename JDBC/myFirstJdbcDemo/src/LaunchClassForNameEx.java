import java.sql.DriverManager;
import java.sql.SQLException;

public class LaunchClassForNameEx {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    }
}
class Demo{
    static {
        System.out.println("Static Block");
    }
    {
        System.out.println("Instatnce Block ==> Non Static");
    }
}
