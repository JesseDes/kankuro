package core;

import java.awt.*;

import javax.swing.*;  
/**
* {@inheritDoc}
* <p>
* {@code AppView} Is the application view. It creates the primary window for the application.
* containers, buttons and other GUI elements can be added with the {@code addtoFrame} method.
*/
public class AppView implements IView {
   public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
   public static final int APP_HEIGHT = (int) SCREENSIZE.getHeight();
   public static final int APP_WIDTH = APP_HEIGHT/3;
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
    
    public void makeLive() {
    	_appFrame.pack();
    	_appFrame.setVisible(true);
    }
    
    
    /**
    * {@inheritDoc}
    * <p>
    *Class Constructor
    */
    private AppView() {
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	_appFrame = new JFrame();
        _appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	_appFrame.setVisible(true);
    	_appFrame.setResizable(false); //For now
    	_appFrame.setSize(APP_HEIGHT,APP_WIDTH);
    	_appFrame.setTitle(APP_TITlE);
    }
    
}
