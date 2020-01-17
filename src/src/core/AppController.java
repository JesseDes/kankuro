package core;
/**
* {@inheritDoc}
* <p>
* {@code AppController} Is the application controller. It handles communication to the application view and model
* as well as any application wide events.
*/
public class AppController implements IController {
    private static AppController instance = null; 
   
    
    /**
    * {@inheritDoc}
    * <p>
    * Returns static singleton instance for application Controller.
    * If the instance has not yet been created calling this function
    * will create it.
    */
    public static AppController getInstance() {
    	
    	if(instance == null)
    		instance = new AppController();
    	
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
	
}
