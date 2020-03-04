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

public class MainMenu {
	private OptionsPanel _diffPop;
	private MainMenuModel _model;
	private MainMenuView _view;
	private PuzzleSelector _selector;
	
	public MainMenu()
	{
		_view = new MainMenuView();
		_diffPop = new OptionsPanel(Application.getInstance().getModel().getdifficulties(), new Dimension(500,100) ,false);
		
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