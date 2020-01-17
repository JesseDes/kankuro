package core;

import javax.swing.*;  


public class View {

	   private static View instance = null; 
	   private JFrame _frame;

	    public static View getInstance() {
	    	
	    	if(instance == null) {
	    		instance = new View();
	    	}
	    	
	    	return instance;
	    }
	    
	    private View() {
    		_frame = new JFrame();
    		_frame.setVisible(true); 
    		_frame.setSize(800,600);
	    }

	    	    

}
