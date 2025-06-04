import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection initializeDatabase() throws Exception {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "voting_system"; // Replace if your DB has a different name
        String dbUsername = "root";
        String dbPassword = "ADMIN"; // Add password if your MySQL has one

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
    }
}