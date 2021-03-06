package core;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.*;

/**
* {@inheritDoc}
* <p>
* @author Jesse Desmarais
* @author Antoine Farley 
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
    *@param Component any Java swing component
    */
    public void addToFrame(Component comp)
    {
    	_appMain.add(comp);
    	refreshMain();
    }
	/**
     * {@inheritDoc}
     * <p>
     *Adds the component {@code comp} to the application popup panel (in front of Main).
     *Note : Only 1 Popup is allowed at a time. Existing popups will be removed.
     *@param Any Java swing component we want to add to the application
     */    
    public void addPopup(Component comp)
    {
    	_appPopup.removeAll();
    	_appPopup.add(comp);
    	refreshPopup();
    }
	/**
     * {@inheritDoc}
     * <p>
     *removes the component {@code comp} from the application Main panel
     *@param isSilent if true removes the element without refreshing the output (meaning it will still be there until an add is called)
     */  
    public void removeFromFrame(Component comp, boolean isSilent)
    {
    	_appMain.remove(comp);
    	
    	if(!isSilent)
    		refreshMain();
    }
	/**
     * {@inheritDoc}
     * <p>
     *Completely Clears the Main Panel
     *@param isSilent if true removes the element without refreshing the output (meaning it will still be there until an add is called)
     */
    public void removeAllFromFrame(boolean isSilent)
    {
    	_appMain.removeAll();
    	if(!isSilent)
    		refreshMain();
    }
	/**
     * {@inheritDoc}
     * <p>
     *Removes Current Popup from the popup Panel
     */
    public void removePopup()
    {
    	_appPopup.removeAll();
    	refreshPopup();

    }
    /**
    * {@inheritDoc}
    * <p>
    *Class Constructor creates JFrame and layeredPane adds Main and popup Panels to the layered pane.
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
    	_layeredPane.add(_appPopup, 1, 0);
    	_appFrame.add(_layeredPane);
    }
    /**
     * {@inheritDoc}
     * <p>
     *Refreshes the view to reflect any added or removed components.
     */
     private void refreshMain()
     {
     	_appMain.setSize(_appMain.getPreferredSize());
     	
     	Dimension size = _appMain.getPreferredSize();

     	//Calculates taskbar Height and border width of the window;
     	_appFrame.pack();
     	size.height += _appFrame.getHeight() - _appFrame.getContentPane().getHeight() ;
     	size.width += _appFrame.getWidth() - _appFrame.getContentPane().getWidth();
     	
     	//sets size
     	_appFrame.setSize(size);
     	
     }
     
     /**
      * {@inheritDoc}
      * <p>
      *Refreshes the view to reflect any added or removed components.
      */     
     private void refreshPopup()
     {
      	_appPopup.setSize(_appPopup.getPreferredSize());
     	_appPopup.setBounds(_appMain.getWidth() / 2 - _appPopup.getWidth() / 2, _appMain.getHeight() / 2 - _appPopup.getHeight() / 2,_appPopup.getWidth() , _appPopup.getHeight());
     	_appPopup.revalidate();
     	_appPopup.repaint();
     }
    
}
