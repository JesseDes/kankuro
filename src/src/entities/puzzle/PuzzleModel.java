package entities.puzzle;

import java.util.Arrays;

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
    
    public int[][] getSolution(){
    	return this.sol;
    }
    
	public String[] getSaveData() {
		return this.saveData;
	}
    
	public int getPuzzleGridSize () {
		return this.sol.length;
	}
	
	public String getName()      { return this.name;}
	public int getType(int index) { return this.sol[index][0]; }
	public int getLoVal(int index) { return this.sol[index][1]; }
	public int getUpVal(int index) { return this.sol[index][2]; }
    	public boolean hasSave() { return this.hasSave;}
   	public int getId() { return this.id;}
}
