package entities.puzzle;

import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.GridPanelLoad;
import GUI.TextPopup;
import core.Application;

public class Puzzle {
	
	int[][] puzzleGrid;
	public static PuzzleModel model;
	public static PuzzleModel load;
	public static PuzzleView view;
	
	/**
	 * Integer array of size 81 containing integer arrays of size 3. 
	 *  [x][0] = GridSquare Type (DisplaySquare if 0, InputSquare if 1)
	 *  [x][1] = lower value if DisplaySquare, disregard if InputSquare. Default is -1
	 *  [x][2] = upper value if DisplaySquare, disregard if InputSquare. Default is -1
	 */
	
	public Puzzle() {
		
		Puzzle.model = Application.getInstance().getModel().getPuzzleModel(1);
		Puzzle.load = Application.getInstance().getModel().loadPuzzleModel();
		
		
		view = new PuzzleView(model);
		
		
		view.getUndoBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				view.getGridPanel().undoLastOperation();
			}
		});
		
		view.getResetBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				view.getGridPanel().clearBoard();
			}
		});
		
		view.getCheckBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(view.getGridPanel().isSolved())
					Application.getInstance().getView().addPopup(new TextPopup("You win"));
				else
					Application.getInstance().getView().addPopup(new TextPopup("Incorrect"));
			}
		});
		
		/////////////////////////////////////////////////////////
		view.getSaveBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				view.getGridPanelLoad().saveState();
				
			}
		});
		
		view.getLoadBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				view.getGridPanelLoad().loadState();
				
			}
		});
		/////////////////////////////////////////////////////////////
		
		Application.getInstance().getView().addToFrame(view);
		
	}
	
}
