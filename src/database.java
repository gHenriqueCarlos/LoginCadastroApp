import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static Connection dbConnection;

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";

    public static Connection GetConnection() {
        try {
            if (dbConnection == null) {
                dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            }
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
