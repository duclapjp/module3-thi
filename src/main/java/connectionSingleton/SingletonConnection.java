package connectionSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    public SingletonConnection() {}

    // đặt tên database financial_management cho đồng bộ nhé
    private static String jdbcURL = "jdbc:mysql://localhost:3306/librarymanager?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "duclap123";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //tạo kết nối (connection)
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                System.out.println("success");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
