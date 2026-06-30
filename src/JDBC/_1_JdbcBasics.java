package JDBC;
// Inserting values into Database.

import java.sql.*;

public class _1_JdbcBasics {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load and Register the Driver - convert jdbc call into specific db
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection to the db by - Getting a Connection object in a interface.
        String url="jdbc_url";
        String user="username";
        String password="password";
        Connection connect = DriverManager.getConnection(url,user,password);

        // Creating Statement Object
        Statement statement = connect.createStatement();

        // Execute The Query
        String sql="INSERT INTO studentInfo(id,sname,sage,scity) VALUES(2,'Gupta',21,'Gwalior')";
        int rowAffected = statement.executeUpdate(sql);

        // Process the result
        if(rowAffected==0) System.out.println("Unable to insert the data");
        else System.out.println("Data inserted Successfully !");

        // Close the resources
        statement.close();
        connect.close();

    }
}
