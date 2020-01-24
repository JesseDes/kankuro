package entities.puzzle;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Puzzle {
	
	int[][] puzzleGrid;

	private OnlinePuzzleParser parser;
	/**
	 * Integer array of size 81 containing integer arrays of size 3. 
	 *  [x][0] = GridSquare Type (DisplaySquare if 0, InputSquare if 1)
	 *  [x][1] = lower value if DisplaySquare, disregard if InputSquare. Default is -1
	 *  [x][2] = upper value if DisplaySquare, disregard if InputSquare. Default is -1
	 */
	
	public int getPuzzleGridSize () {
		return this.puzzleGrid.length;
	}
	
	public int getType(int index) { return this.puzzleGrid[index][0]; }
	public int getLoVal(int index) { return this.puzzleGrid[index][1]; }
	public int getUpVal(int index) { return this.puzzleGrid[index][2]; }
	
	public Puzzle() {
		this.puzzleGrid = new int[8*9][3];
		this.parser = new OnlinePuzzleParser();
		this.parser.traverse(this.puzzleGrid);
		System.out.println(Arrays.deepToString(this.puzzleGrid));
	}
	
	
	
}
