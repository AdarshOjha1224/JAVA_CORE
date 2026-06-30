package JDBC;
import java.sql.*;

public class JdbcUtil {
    static {
        // Load and Register the Driver - convert jdbc call into specific db
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // Establish the connection to the db by - Getting a Connection object in a interface.
        String url = "jdbc:mysql://127.0.0.1:3306/jdbcLearning";
        String user = "adarsh";
        String password = "Adarsh0905$$";
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection connect, Statement statement) throws SQLException {
        // Close the resources
        statement.close();
        connect.close();
    }
}
