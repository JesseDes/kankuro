package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.puzzle.*;
import entities.puzzleSelector.PuzzleSelectorModel;

/**
* {@inheritDoc}
* <p>
* @author Jesse Desmrais
* @author Marc Hegedus
* @author Yaroslav Bilodid
* {@code AppModel} Is the application model. It handles data that is universal to the application.
*/
public class AppModel {

	private static final String DB_URL = "jdbc:sqlite:data/kakuro.db";
	private Connection _conn;
	
	/**
	 * {@inheritDoc}
	 * Retrieves all puzzles for a specified difficulty and loads them into a puzzleSelector Model
	 * @param difficulty the difficulty for the puzzles that we want to look up
	 * @return PuzzleSelectorModel array containing the Models for each puzzle of a specific difficulty
	 */
	public PuzzleSelectorModel[] getPuzzleList(String difficulty) {
		String sql = "SELECT * FROM puzzles WHERE Difficulty = '" + difficulty + "';";
		String countSql = "SELECT COUNT(*) FROM puzzles WHERE Difficulty = '" + difficulty + "';";
		int rowCount = 0;
		
		//retrieves the number of difficulties
		try
		{
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(countSql);
			rowCount = rs.getInt("COUNT(*)");
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		PuzzleSelectorModel puzzleList[] = new PuzzleSelectorModel[rowCount];
		
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			rs.next();

			for(int i =0 ; i < rowCount ;i++)
			{
				puzzleList[i] = new PuzzleSelectorModel(rs.getString("name"), rs.getInt("id") , rs.getString("Difficulty"));
				rs.next();
			}
			
			stmt.close();

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return puzzleList;
	}
	/**
	* {@inheritDoc}
	* <p>
	* saves puzzle data.
	* @param id the puzzleId for puzzle we are saving
	* @param saveData an Stringified array of values for each square in the puzzle 
	* @param isUpdate flag to determine if we are creating a new save or overwritting an existing one
	*/
	public void savePuzzleData(int id, String saveData , boolean isUpdate) {
		String sql;
		
		if(isUpdate)
			sql = "UPDATE State SET data = '" + saveData + "' WHERE PuzzleId = " + id + ";";
		else
			sql = "INSERT INTO State ( 'PuzzleId', 'data') VALUES ( ' " + id + "', '" + saveData + "');";

		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	* {@inheritDoc}
	* <p>
	* Loads the save data for a specific puzzle.
	* @param id The puzzle Id for the puzzle we would like to retireve the save file for
	* @return Returns the Stringified array of save data
	* 
	*/
	public String getPuzzleSave(int id) {
		String sql = "SELECT * FROM State WHERE PuzzleId = " + id + ";";
		String countSQl = "SELECT COUNT(*) FROM State WHERE PuzzleId = " + id + ";";
		int rowCount = 0;
		String data = "";
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(countSQl);
			rowCount = rs.getInt("COUNT(*)");
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(rowCount > 0)
		{
			try {
				Statement stmt  = _conn.createStatement();
				ResultSet rs  = stmt.executeQuery(sql);
				data = rs.getString("data");	
				stmt.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return data;
	}
	
	/**
	* {@inheritDoc}
	* <p>
	* Deletes a specified save file
	* @param The puzzle id of the puzzle we want to delete.
	*/
	public void deletePuzzleSave(int id) {
		String sql = "DELETE FROM State WHERE PuzzleId = " + id + ";";		
		try {
			Statement stmt  = _conn.createStatement();
			stmt.executeQuery(sql);
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	/**
    * {@inheritDoc}
    * <p>
    *  Retrieves puzzle with matching ID, if none found returns an empty puzzle;
    * @param id the puzzle Id of the puzzle we want to retrieve.
    * @return PuzzleModel puzzle data object
    */
	public PuzzleModel getPuzzleModel(int id) {
		String sql = "SELECT * FROM puzzles WHERE id = " + id + ";";
		PuzzleModel puzzle = null;
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			String saveData = getPuzzleSave(rs.getInt("id"));
			
			if(saveData.equals(""))
				puzzle = new PuzzleModel(rs.getString("solution") , rs.getString("name") , rs.getInt("id"));
			else
				puzzle = new PuzzleModel(rs.getString("solution") , saveData , rs.getString("name") , rs.getInt("id"));
			stmt.close();

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return puzzle;
	}

	/**
    * {@inheritDoc}
    * <p>
    * Retrieves puzzle with matching name, if none found returns an empty puzzle;
    * @param name the name of the puzzle we want to retrieve.
    * @return PuzzleModel puzzle data object
    */
	public PuzzleModel getPuzzleModel(String name) {
		String sql = "SELECT * FROM puzzles WHERE name = '" + name + "';";
		PuzzleModel puzzle = null;
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			String saveData = getPuzzleSave(rs.getInt("id"));
			if(saveData.equals(""))
				puzzle = new PuzzleModel(rs.getString("solution") , rs.getString("name") , rs.getInt("id"));
			else
				puzzle = new PuzzleModel(rs.getString("solution") , saveData , rs.getString("name") , rs.getInt("id"));		
			stmt.close();

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return puzzle;
	}
	
	/**
    * {@inheritDoc}
    * <p>
    * Retrieves the list of difficulties that are currently in the database;
    * @return array of Strings for each difficulty
    */
	public String[] getdifficulties() {
		String sql = "SELECT title FROM difficulties";
		String[] diffList = null;
		String countSql = "SELECT COUNT(*) FROM difficulties";
		int rowCount = 0;
		
		//retrieves the number of difficulties
		try
		{
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(countSql);
			rowCount = rs.getInt("COUNT(*)");
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		//retrieves difficulties
		try {
			Statement stmt  = _conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			diffList = new String[rowCount];
			int i =0;
			
			while(rs.next())
			{
				diffList[i] = rs.getString("title");
				i++;
			}
			stmt.close();
				
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return diffList;
	}
	
	
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
