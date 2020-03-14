package entities.puzzleSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import core.Application;
import entities.puzzle.Puzzle;
import entities.puzzle.PuzzleModel;

/**
 * 
 * @author Jesse Desmarais
 * Class that lists puzzles for a given diffuculty in a scrollable dynamic Jpanel and allows you to select one
 * calls the Application to set current puzzle to selected puzzle
 */

public class PuzzleSelector {

	private PuzzleSelectorModel[] _model;
	private PuzzleSelectorView _view;
	
	/**
	 * constructor instantiate view and model and adds ActionListeners for each puzzle play button
	 * @param puzzleList the list of puzzleData for some specific difficulty
	 * @throws IOException if puzzle images in view cannot be found
	 */
	public PuzzleSelector(PuzzleSelectorModel[] puzzleList) throws IOException
	{
		_model = puzzleList.clone();
		
		_view = new PuzzleSelectorView(_model);
		
		for(int i =0 ; i < _view.getButtonList().length; i++)
		{
			_view.getButtonList()[i].addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					//retrieves puzzle from name which is retrieve form button clicked on
					//substring 5 removes "play " part from button text which has format "Play " + name
					PuzzleModel puzMod = Application.getInstance().getModel().getPuzzleModel(e.getActionCommand().substring(5));
					Application.getInstance().AppSetPuzzle(puzMod);
				}
			});
		}
	}
	/**
	 * 
	 * @return PuzzleSelector view
	 */
	public PuzzleSelectorView display() {return _view;}
}
