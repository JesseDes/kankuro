package core;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

 
/**
* {@inheritDoc}
* <p>
* {@code AppView} Is the application view. It creates the primary window for the application.
* containers, buttons and other GUI elements can be added with the {@code addtoFrame} method.
*/
public class AppView {
   public static final String APP_TITlE = "Kakuro";
	
   private JFrame _appFrame;
   private JLayeredPane _layeredPane;
   private JPanel _appMain;
   private JPanel _appPopup;
	/**
    * {@inheritDoc}
    * <p>
    *Adds the component {@code comp} to the application main panel
    */
    public void addToFrame(Component comp)
    {
    	_appMain.add(comp);
    	refresh();
    }
	/**
     * {@inheritDoc}
     * <p>
     *Adds the component {@code comp} to the application popup panel (in front of Main).
     *Note : Only 1 Popup is allowed at a time. Existing popups will be removed.
     */    
    public void addPopup(Component comp)
    {
    	_appPopup.removeAll();
    	_appPopup.add(comp);
    	refresh();
    }
	/**
     * {@inheritDoc}
     * <p>
     *removes the component {@code comp} from the application Main panel
     */  
    public void removeFromFrame(Component comp)
    {
    	_appMain.remove(comp);
    	refresh();
    }
	/**
     * {@inheritDoc}
     * <p>
     *Completely Clears the Main Panel
     */
    public void removeAllFromFrame()
    {
    	_appMain.removeAll();
    	refresh();
    }
	/**
     * {@inheritDoc}
     * <p>
     *Removes Current Popup from the popup Panel
     */
    public void removePopup()
    {
    	_appPopup.removeAll();
    	refresh();

    }
    /**
    * {@inheritDoc}
    * <p>
    *Class Constructor
    */
    public AppView() {
    	_appFrame = new JFrame();
    	_appFrame.setVisible(true); 
    	_appFrame.setTitle(APP_TITlE);
        _appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _appFrame.setResizable(false);
        _layeredPane = new JLayeredPane();
    	_appMain = new JPanel();
    	_appPopup = new JPanel();
    	_appPopup.setOpaque(false);
    	_layeredPane.add(_appMain,0,0);
    	_layeredPane.add(_appPopup,1,0);
    	_appFrame.add(_layeredPane);
    	
    }
    /**
     * {@inheritDoc}
     * <p>
     *Refreshes the view to reflect any added or removed components.
     */
     private void refresh()
     {
     	_appMain.setSize(_appMain.getPreferredSize());
     	_appPopup.setSize(_appPopup.getPreferredSize());
     	_layeredPane.revalidate();
     	_layeredPane.repaint();
     	
     	Dimension size = _appMain.getPreferredSize();
     	
     	//Window will resize to the largest x or y value
     	if(_appPopup.getPreferredSize().height > size.height)
     		size.height = _appPopup.getPreferredSize().height;
     	
     	if(_appPopup.getPreferredSize().width > size.width)
     		size.width = _appPopup.getPreferredSize().width;
     	
     	//Calculates taskbar Height and border width of the window;
     	_appFrame.pack();
     	size.height += _appFrame.getHeight() - _appFrame.getContentPane().getHeight() ;
     	size.width += _appFrame.getWidth() - _appFrame.getContentPane().getWidth();
     	
     	//sets size
     	_appFrame.setSize(size);
     	
     }
    
}
