package entities.MainMenu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import GUI.OptionsPanel;
import core.Application;
import entities.puzzle.Puzzle;
import entities.puzzle.PuzzleModel;
import entities.puzzleSelector.PuzzleSelector;
import entities.puzzleSelector.PuzzleSelectorModel;

/**
* {@inheritDoc}
* <p>
* @author Jesse Desmrais
* {@code MainMenu} Is the starting point of the application. Contains 2 buttons to open 
* a puzzle Selector or to exit the application
* 
*/


public class MainMenu {
	private OptionsPanel _diffPop;
	private MainMenuModel _model;
	private MainMenuView _view;
	private PuzzleSelector _selector;
	
	
	/**
	 * Constructor class , creates the view and model and difficulty popup. Adds button listeners for all buttons
	 */
	public MainMenu()
	{
		_view = new MainMenuView();
		_model = new MainMenuModel(Application.getInstance().getModel().getdifficulties());
		_diffPop = new OptionsPanel(_model.getDifficultyList(), new Dimension(300,230), "Select Difficulty");
		
		_view.getNewButton().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().addPopup(_diffPop);
			}
		});
		
		_view.getCloseButton().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().closeApp();
			}
		});
		
		
		// For each difficulty button adds ActionListener to create a puzzle selector for that difficulty.
		for(int i = 0 ; i < _diffPop.getOptions().length ; i++)
		{
			_diffPop.getOptions()[i].addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try {
						_selector = new PuzzleSelector(Application.getInstance().getModel().getPuzzleList(e.getActionCommand()));
						Application.getInstance().getView().addPopup(_selector.display());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
	}
	
	public MainMenuView display() { return _view;} 
}