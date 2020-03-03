package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.SampleMVCButton.SampleButtonModel;
import entities.puzzle.*;

/**
* {@inheritDoc}
* <p>
* {@code AppModel} Is the application model. It handles data that is universal to the application.
*/
public class AppModel {

	private static final String DB_URL = "jdbc:sqlite:data/kakuro.db";
	private Connection _conn;

   /**
    * {@inheritDoc}
    * <p>
    * Retrieves button with matching ID, if none found returns an empty button;
    */
	public SampleButtonModel getButtonData(int id)
	{
		String sql = "SELECT * FROM Buttons WHERE id = " + id + ";";
		SampleButtonModel button;
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			button = new SampleButtonModel(rs.getInt("id") , rs.getString("text"), rs.getInt("type") );
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			button = new SampleButtonModel(0,"SQL ERROR",0);
		}
		
		return button;
	}
	
	/**
    * {@inheritDoc}
    * <p>
    * Retrieves puzzle with matching ID, if none found returns an empty puzzle;
    */
	public PuzzleModel getPuzzleModel(int id) {
		String sql = "SELECT * FROM puzzles WHERE id = " + id + ";";
		PuzzleModel puzzle = null;
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			puzzle = new PuzzleModel(rs.getString("solution"));
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return puzzle;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	* {@inheritDoc}
	* <p>
	* loads puzzle
	*/
	public PuzzleModel loadPuzzleModel() {
		String sql = "SELECT * FROM State WHERE id = " + 1 + ";";
		PuzzleModel puzzle = null;
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			puzzle = new PuzzleModel(rs.getString("data"));	
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			
		return puzzle;
	}
	///////////////////////////////////////////////////////////////////////////////////////
	
    /**
    * {@inheritDoc}
    * <p>
    * Class constructor
    */
	public AppModel()
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
			_conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection to SQLite has been established.");
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
