package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    static final String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    static private ConnectionBuilder instance;
    private static Connection connection;

    public static ConnectionBuilder getInstance(){
        if(instance == null) {
            instance = new ConnectionBuilder();
        }
        return instance;
    }

    private ConnectionBuilder(){
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
