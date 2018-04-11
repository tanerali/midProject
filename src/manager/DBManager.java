package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBManager {

	private static DBManager instance;
	// Gotta be included later
	private static final String DB_IP = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "AirbnbDB";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String URL = "jdbc:mysql://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sc";
	private Connection conn;

	private DBManager() {
		//load driver
		try {
			
			
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(DBManager.URL, DBManager.DB_USER, DBManager.DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Sorry, Driver not loaded or does not exist! Aborting.");
            e.printStackTrace();
        }
        System.out.println("Driver loaded");
        //create connection
	}

	public static DBManager getInstance() {
		if (DBManager.instance == null) {
			synchronized (DBManager.class) {
				if (DBManager.instance == null) {
					DBManager.instance = new DBManager();
				}
			}
		}
		return DBManager.instance;
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
