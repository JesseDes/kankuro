package core;

import entities.MainMenu.MainMenu;
import entities.puzzle.Puzzle;
import entities.puzzle.PuzzleModel;

/**
* {@inheritDoc}
* <p>
* {@code Application} Is the application controller. It handles communication to the application view and model
* as well as any application wide events.
*/
public class Application {
    private static Application instance = null; 
    
    private AppView _view = new AppView();
    private AppModel _model = new AppModel();
    private MainMenu _menu;
    private Puzzle _currentPuzzle;
    
    /**
    * {@inheritDoc}
    * <p>
    * Returns static singleton instance for application Controller.
    * If the instance has not yet been created calling this function
    * will create it.
    */
    public static Application getInstance() {
    	
    	if(instance == null)
    	{
    		instance = new Application();
    		instance._menu = new MainMenu();
    		instance.AppDisplayMenu();
    	}
    	
    	return instance;
    }
    /**
    * {@inheritDoc}
    * <p>
    * Terminates Application.
    */
    public void closeApp()
    {
    	System.exit(0);
    }
    
    public AppView getView()
    {
    	return _view;
    }
	
    public AppModel getModel()
    {
    	return _model;
    }
    
    public void AppDisplayMenu()
    {
    	if(_currentPuzzle != null)
    	{
    		_view.removeFromFrame(_currentPuzzle.display(), true);
    		_currentPuzzle = null;
    	}
    	
    	_view.addToFrame(_menu.display());
    }
    
    public void AppSetPuzzle(PuzzleModel puzzleData)
    {
    	_currentPuzzle = new Puzzle(puzzleData);
    	_view.removeFromFrame(_menu.display(), true);
    	_view.removePopup();
    	_view.addToFrame(_currentPuzzle.display());
    }
    
}