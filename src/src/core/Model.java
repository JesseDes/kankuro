package core;

public class Model {
	   private static Model instance = null; 
	    
	    public static Model getInstance() {
	    	
	    	if(instance == null)
	    		instance = new Model();
	    	
	    	return instance;
	    }
	    
	    
	    public String myName = "Model";
}
