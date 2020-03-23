package entities.puzzle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.TextPopup;
import core.Application;

/**
 * 
* @author Yaroslav Bilodid
 *@author Antoine Farley
 *
 *Puzzle class, instantiates puzzle view and model checks if a save exists for the current puzzle, Adds Actionalisteners for PuzzleViewButtons
 */

public class Puzzle {
	
	private PuzzleModel model;
	private PuzzleView view;
	private boolean usedLoad = false;
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
				
				TextPopup checkPop;
				//if the puzzle is solved on check we display a you win popup otherwise incorrect popup
				
				if(view.getGridPanel().isSolved())
				{
					checkPop = new TextPopup("You win" , "Return to Menu");
					
					//If we loaded a save file and completed the puzzle we can remove the save as the "session is completed"
					if(usedLoad)
						Application.getInstance().getModel().deletePuzzleSave(model.getId()); 
				
					checkPop.getCloseBtn().addActionListener( new ActionListener() {
						public void actionPerformed(ActionEvent e)
						{
							 Application.getInstance().AppDisplayMenu(); 
						}
					});
				}
				else
					checkPop = new TextPopup("Incorrect");
				
				Application.getInstance().getView().addPopup(checkPop);

			}
		});

		view.getCloseBtn().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().addPopup(view.displaySavePrompt());
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
				usedLoad = true;
				Application.getInstance().getView().removePopup();
				view.getGridPanel().loadSaveFile(model.getSaveData());
			}
		});
		
		if(model.hasSave())
			Application.getInstance().getView().addPopup(view.displayLoadPrompt());
	}
	
	public PuzzleView display() { return view;}
	
}
