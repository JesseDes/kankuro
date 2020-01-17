package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
* {@inheritDoc}
* <p>
* {@code AppModel} Is the application model. It handles data that is universal to the application.
*/
public class AppModel implements IModel {

	private static final String DB_URL = "jdbc:sqlite:data/kakuro.db";
	private Connection conn;
	private static AppModel instance = null; 
	
    /**
    * {@inheritDoc}
    * <p>
    * Returns static singleton instance for application Model.
    * If the instance has not yet been created calling this function
    * will create it.
    */
	public static AppModel getInstance() {
    	
    	if(instance == null)
    		instance = new AppModel();
    	
    	return instance;
    }
    /**
    * {@inheritDoc}
    * <p>
    * Class constructor
    */
	private AppModel()
	{
		loadDB();
	}
    /**
    * {@inheritDoc}
    * <p>
    * Loads the application database so it can be queried for data.
    */
	private void loadDB()
	{	
		try {
			conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection to SQLite has been established.");
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
