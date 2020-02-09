package entities.puzzle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.TextPopup;
import core.Application;

public class Puzzle {
	
	int[][] puzzleGrid;
	private PuzzleModel model;
	private PuzzleView view;
	/**
	 * Integer array of size 81 containing integer arrays of size 3. 
	 *  [x][0] = GridSquare Type (DisplaySquare if 0, InputSquare if 1)
	 *  [x][1] = lower value if DisplaySquare, disregard if InputSquare. Default is -1
	 *  [x][2] = upper value if DisplaySquare, disregard if InputSquare. Default is -1
	 */
	
	public Puzzle() {
		
		this.model = Application.getInstance().getModel().getPuzzleModel(1);
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
		
		
		Application.getInstance().getView().addToFrame(view);
	}
	
}
