package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
       private final String Path = "DB/NhanVien.db";
       private Connection connection;
       final String url = "jdbc:sqlite:" + Path;
       public Database(){

           try {
               connection = DriverManager.getConnection(url);
               createEmployeesTable(connection);
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    public static void createEmployeesTable(Connection connection) throws SQLException {

        String SQL_CREATE_EMPLOYEES_TABLE = "CREATE TABLE IF NOT EXISTS EmployeesTable (\n"
                + "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "    FullName TEXT NOT NULL,\n"
                + "    Gender INTEGER\n"
                + ");";
        Statement statement = connection.createStatement();
        statement.execute(SQL_CREATE_EMPLOYEES_TABLE);
    }
    public Connection getConnection() {
        return connection;
    }
    public  void CloseConnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
