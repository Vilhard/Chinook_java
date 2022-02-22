package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    static final String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    static private ConnectionHelper instance;
    private static Connection connection;

    public static ConnectionHelper getInstance(){
        if(instance == null) {
            instance = new ConnectionHelper();
        }
        return instance;
    }

    private ConnectionHelper(){
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
