package core;
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
    /**
    * {@inheritDoc}
    * <p>
    * Returns static singleton instance for application Controller.
    * If the instance has not yet been created calling this function
    * will create it.
    */
    public static Application getInstance() {
    	
    	if(instance == null)
    		instance = new Application();
    	
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
    
}
