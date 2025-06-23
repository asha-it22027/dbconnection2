import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/library"; // Use your DB name
        String user = "root";
        String password = "asha25"; // Your MySQL password
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}