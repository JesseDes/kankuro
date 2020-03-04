package entities.puzzleSelector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import core.Application;
import entities.puzzle.Puzzle;
import entities.puzzle.PuzzleModel;

public class PuzzleSelector {

	private PuzzleSelectorModel[] _model;
	private PuzzleSelectorView _view;
	
	public PuzzleSelector(PuzzleSelectorModel[] puzzleList) throws IOException
	{
		_model = puzzleList.clone();
		
		_view = new PuzzleSelectorView(_model);
		
		for(int i =0 ; i < _view.getButtonList().length; i++)
		{
			_view.getButtonList()[i].addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					System.out.println(e.getActionCommand().substring(5));
					PuzzleModel puzMod = Application.getInstance().getModel().getPuzzleModel(e.getActionCommand().substring(5));
					Application.getInstance().AppSetPuzzle(puzMod);
					
				}
			});
		}
	}
	
	public PuzzleSelectorView display() {return _view;}
}
