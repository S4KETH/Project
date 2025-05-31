import java.sql.Connection;
import java.sql.DriverManager;
public class DBconnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb", "root", "saketh"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
