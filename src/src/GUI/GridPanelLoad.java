package GUI;

import javax.swing.*;

import entities.puzzle.PuzzleModel;
import entities.puzzle.Puzzle;
import core.AppModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class GridPanelLoad extends JPanel {
	
	private GridSquare[] gridSquaresLoad;
	
	public GridPanelLoad() {
		
		this.gridSquaresLoad = new GridSquare[100];
		this.populateGridPanel(Puzzle.load);
		
	}
	
	/**
	 * Load a state from the database
	 */
	public void loadState() {
		
		GridPanel Gridbox;
		Gridbox = Puzzle.view.getGridPanel();
		
		for(int i = 0; i < gridSquaresLoad.length; i++) {
		
			if(gridSquaresLoad[i].getType() == 1) {
				String t;
				
				if(gridSquaresLoad[i].getIs().getCorrectValue() == 0) {
					Gridbox.gridSquares[i].getIs().setText("");
				}else {
					t = "" + gridSquaresLoad[i].getIs().getCorrectValue();
					System.out.print(t);
					Gridbox.gridSquares[i].getIs().setText(t);
				}
				
			}
		
		}
	
	}
	
	/**
	 * Load a state from the database
	 */
	public void saveState() {
		
		String DB_URL = "jdbc:sqlite:data/kakuro.db";
		Connection _conn;
		
		GridPanel Gridbox;
		Gridbox = Puzzle.view.getGridPanel();
		
		int[][] sol = new int[100][3];
		
		sol = Puzzle.model.getSolution();
		String t = "";
	
		try {
			_conn = DriverManager.getConnection(DB_URL);
			Statement stmt  = _conn.createStatement();
			
			for(int i = 0; i < Gridbox.gridSquares.length; i++) {
			
				if( Gridbox.gridSquares[i].getType() == 1 ) {
					
					
					if(Gridbox.gridSquares[i].getIs().getCurrentValue() != -1) {
						
						sol[i][1] = ( Gridbox.gridSquares[i].getIs().getCurrentValue() );
						t = t + sol[i][0] + " " + sol[i][1] + " " + sol[i][2] + ",";
						
					}else {
						
						sol[i][1] = 0;
						t = t + sol[i][0] + " " + sol[i][1] + " " + sol[i][2] + ",";
						
					}
					
				}else
					t = t + sol[i][0] + " " + sol[i][1] + " " + sol[i][2] + ",";
			
			}
			
			String sql = "UPDATE State SET data = '"+t+"' WHERE id = " + 1;
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		PuzzleModel refreshData = new PuzzleModel(t);
		this.populateGridPanel(refreshData);
		System.out.print(t);
	
	}
	
	public void populateGridPanel(PuzzleModel puzzleArr ) {
		for (int i = 0; i< puzzleArr.getPuzzleGridSize(); i++) {
			if(puzzleArr.getType(i) != 2){
                gridSquaresLoad[i] = new GridSquare(0, i);
                gridSquaresLoad[i].setSquare_C(puzzleArr.getUpVal(i), puzzleArr.getLoVal(i));
            	
            }
            else {
            	gridSquaresLoad[i] = new GridSquare(1, i);
            	gridSquaresLoad[i].setSquare_C(puzzleArr.getLoVal(i), puzzleArr.getUpVal(i));
            }
            this.add((gridSquaresLoad[i].getType()==0) ? gridSquaresLoad[i].getDs() : gridSquaresLoad[i].getIs());

		}
	}

}