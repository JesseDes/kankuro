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
	
	public Puzzle(PuzzleModel puzzleData) {
		
		model = puzzleData;
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
		
		view.displaySavePrompt().getCancelBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().removePopup();
				Application.getInstance().AppDisplayMenu();
			}
		});
		
		view.displaySavePrompt().getActionBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getModel().savePuzzleData(model.getId(), view.getGridPanel().getSaveData(), model.hasSave());
				Application.getInstance().getView().removePopup();
				Application.getInstance().AppDisplayMenu();
			}
		});
		
		view.displayLoadPrompt().getCancelBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().removePopup();
			}
		});
		
		view.displayLoadPrompt().getActionBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().removePopup();
				view.getGridPanel().loadSaveFile(model.getSaveData());
			}
		});
		
		if(model.hasSave())
			Application.getInstance().getView().addPopup(view.displayLoadPrompt());
	}
	
	public PuzzleView display() { return view;}
	
}
