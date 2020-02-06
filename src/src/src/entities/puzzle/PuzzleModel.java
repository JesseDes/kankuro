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
    public int[][] sol = new int[100][3];
    
    public PuzzleModel(String solution){
        String solarr[] = solution.split(",");
        for(int i = 0; i < sol.length; i++) {
        	int[] cell_data = new int[3];
        	String raw_data[] = solarr[i].split(" ");
        	for(int j = 0; j< raw_data.length; j++) {
        		cell_data[j] = Integer.parseInt(raw_data[j]);
        	}
        	sol[i] = cell_data;
        }
    }
    
}
