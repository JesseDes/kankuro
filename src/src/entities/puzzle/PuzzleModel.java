package entities.puzzle;

import java.util.Arrays;

/**
 * 
* @author Yaroslav Bilodid
* @author Marc Hegedus
* @author Jesse Desmarais
 */


public class PuzzleModel {
	
	/*
	 * Solution array where every arr[3] represents a single cell starting from 0 to 99
	 * There are 3 types of the cell that are given as arr[0]:
	 *  0 - not playable cell. Always [0, -1, -1]
	 *  1 - task cell. [1, top value, bottom value]
	 *  2 - input cell. [2, solution value, 0]
	 */
    private int[][] sol = new int[100][3];
    private String[] saveData = new String[100];
    private boolean hasSave;
    private String name;
    private int id;
    
    /**
     * Constructor creates model data, parses solution data string into solution array sets hasSave to false 
     * @param solution the Stringified solution data
     * @param name The puzzle Name
     * @param id the Puzzle Id
     */
    public PuzzleModel(String solution, String name , int id){
        String solarr[] = solution.split(",");
        for(int i = 0; i < sol.length; i++) {
        	int[] cell_data = new int[3];
        	String raw_data[] = solarr[i].split(" ");
        	for(int j = 0; j< raw_data.length; j++) {
        		cell_data[j] = Integer.parseInt(raw_data[j]);
        	}
        	sol[i] = cell_data;
        }
        this.name = name;
        this.hasSave = false;
        this.id = id;
    }
    
    /**
     * Constructor creates model data, parses solution data string into solution array and parses save string into saveData array, sets hasSave to true 
     * 
     * @param solution the Stringified solution data
     * @param save the stringified save data
     * @param name The puzzle Name
     * @param id the Puzzle Id
     */
    public PuzzleModel(String solution, String save , String name , int id){
        String solarr[] = solution.split(",");
        for(int i = 0; i < sol.length; i++) {
        	int[] cell_data = new int[3];
        	String raw_data[] = solarr[i].split(" ");

        	for(int j = 0; j< raw_data.length; j++) {
        		cell_data[j] = Integer.parseInt(raw_data[j]);
        	}
        	sol[i] = cell_data;
        }
        
        saveData = save.split(",");

        
        this.hasSave = true;
        this.name = name;
        this.id = id;
    }
    
    /**
     * 
     * @return puzzle solution array
     */
    
    public int[][] getSolution(){
    	return this.sol;
    }
    
    /**
     * 
     * @return returns savedata array
     */
	public String[] getSaveData() {
		return this.saveData;
	}
    
	/**
	 * 
	 * @return returns length of the grid puzzle
	 */
	public int getPuzzleGridSize () {
		return this.sol.length;
	}
	
	/**
	 * 
	 * @return puzzle name
	 */
	public String getName()      { return this.name;}
	
	/**
	 * 0 - Blank puzzle square
	 * 1 - display square to show sum value
	 * 2 - input square
	 * @param index of square you want to access
 	 * @return grid type
	 */
	
	public int getType(int index) { return this.sol[index][0]; }
	/**
	 * 
	 * @param index of square you want to access
	 * @return lower value of square
	 */
	public int getLoVal(int index) { return this.sol[index][1]; }
	/**
	 * 
	 * @param index of square you want to access
	 * @return upper value of square
	 */
	public int getUpVal(int index) { return this.sol[index][2]; }
	/**
	 * 
	 * @return if puzzle has save data
	 */
    public boolean hasSave() { return this.hasSave;}
	/**
	 * 
	 * @return Puzzle ID
	 */
    public int getId() { return this.id;}
}
