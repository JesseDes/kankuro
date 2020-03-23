package core;


import entities.MainMenu.MainMenu;
import entities.puzzle.Puzzle;
import entities.puzzle.PuzzleModel;
import test.Tester;

/**
* {@inheritDoc}
* <p>
 * @author Jesse Desmarais
* {@code Application} Is the application controller. It handles communication to the application view and model
* as well as any application wide events.
* 
*/
public class Application {
    private static Application instance = null; 
    
    private AppView _view = new AppView();
    private AppModel _model = new AppModel();
    private MainMenu _menu;
    private Puzzle _currentPuzzle;
    
    /**
    * {@inheritDoc}
    * Returns static singleton instance for application Controller.
    * If the instance has not yet been created calling this function
    * will create it.
    */
    public static Application getInstance() {
    	
    	if(instance == null)
    	{
    		instance = new Application();
    		
    		//If any tests fail the app is terminated
    		if(!Tester.runAllTests())
    			instance.closeApp();
    		
    		instance._menu = new MainMenu();
    		instance.AppDisplayMenu();
    	}
    	
    	return instance;
    }
    /**
    * {@inheritDoc}
    * Terminates Application.
    */
    public void closeApp()
    {
    	System.exit(0);
    }
    /**
    * {@inheritDoc}
    * <p>
    * @author Jesse Desmarais
    * Serves the Application View.
    * @return AppView the application view for the whole application
    */
    public AppView getView()
    {
    	return _view;
    }
    /**
    * {@inheritDoc}
    * <p>
    * Serves the Application Model.
    * @return AppModel the application model for the whole application
    */
    public AppModel getModel()
    {
    	return _model;
    }
    /**
    * {@inheritDoc}
    * <p>
    * Adds the main menu to view and cleans up any active puzzles
    */
    public void AppDisplayMenu()
    {
    	if(_currentPuzzle != null)
    	{
    		_view.removeFromFrame(_currentPuzzle.display(), true);
    		_currentPuzzle = null;
    	}
    	
    	_view.addToFrame(_menu.display());
    }
    /**
    * {@inheritDoc}
    * <p>
    * Creates puzzle from puzzle data and adds to the view
    * Stores puzzle as current Active puzzle.
    * @param PuzzleData the puzzleModel for the puzzle that is to be the active puzzle
    */
    public void AppSetPuzzle(PuzzleModel puzzleData)
    {
    	_view.removePopup();
    	_currentPuzzle = new Puzzle(puzzleData);
    	_view.removeFromFrame(_menu.display(), true);
    	_view.addToFrame(_currentPuzzle.display());
    }
    
}