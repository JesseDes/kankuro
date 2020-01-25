package core;
/**
* {@inheritDoc}
* <p>
* DEPRECIATED, MOVED TO APPLICATION
*/
public class AppController  {
    private static AppController instance = null; 
   
    
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
