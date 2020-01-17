package core;

import java.awt.Component;
import javax.swing.*;  
/**
* {@inheritDoc}
* <p>
* {@code AppView} Is the application view. It creates the primary window for the application.
* containers, buttons and other GUI elements can be added with the {@code addtoFrame} method.
*/
public class AppView implements IView {
   public static final int APP_HEIGHT = 800;
   public static final int APP_WIDTH = 600;
   public static final String APP_TITlE = "Kakuro";
	
   private static AppView instance = null; 
   private JFrame _appFrame;

    /**
    * {@inheritDoc}
    * <p>
    * Returns static singleton instance for application view.
    * If the instance has not yet been created calling this function
    * will create it.
    */
    public static AppView getInstance() {
    	
    	if(instance == null) {
    		instance = new AppView();
    	}
    	
    	return instance;
    }
	/**
    * {@inheritDoc}
    * <p>
    *Adds the component {@code comp} to the application frame
    */
    public void addToFrame(Component comp)
    {
    	_appFrame.add(comp);
    }
    /**
    * {@inheritDoc}
    * <p>
    *Class Constructor
    */
    private AppView() {
    	_appFrame = new JFrame();
    	_appFrame.setVisible(true); 
    	_appFrame.setSize(APP_HEIGHT,APP_WIDTH);
    	_appFrame.setTitle(APP_TITlE);
    }
    
}
