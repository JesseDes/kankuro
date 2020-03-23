package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.Application;
/**
 * 
 * @author Jesse Desmarais
 * Generic Popup class that displays some text and a single button to close the popup
 */

public class TextPopup extends JPanel {

	private JButton _closeButton;
	private Label _title;
	private Dimension _size;
	
	/**
	 * Constructor creates popup with suppied text, contains a default "Close Popup" button and size of 150x150 
	 * @param popupText the supplied text for popup information
	 */
	public TextPopup(String popupText)
	{
		
		_closeButton = new JButton("Close Popup");
		_title = new Label(popupText,"Calibri", 30);
		_size = new Dimension(150,150);
		
		
		buildGrid();
	}
	/**
	 * Constrcutor creates popup with supplied text , and supplied button label uses default size 150x150
	 * @param popupText the supplied text String for popup information
	 * @param btnText  the text label String for the close button
	 */
	public TextPopup(String popupText , String btnText)
	{
		_title = new Label(popupText,"Calibri", 30);
		_closeButton = new JButton(btnText);
		_title = new Label(popupText,"Calibri", 30);
		_size = new Dimension(150,150);

		buildGrid();
	}
	/**
	 * Constructor creates popup with supplied popup text, button text and size
	 * @param popupText the supplied text String for popup information
	 * @param btnText  the text label String for the close button
	 * @param size the length and width of the popup
	 */
	public TextPopup(String popupText , String btnText, Dimension size)
	{
		_title = new Label(popupText,"Calibri", 30);
		_closeButton = new JButton(btnText);
		_title = new Label(popupText,"Calibri", 30);
		_size = size;

		buildGrid();
	}
	
	 /**
	  * sets up constraints and adds buttons to the Jpanel
	  */
	private void buildGrid()
	{
		setPreferredSize(_size);
		_closeButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().removePopup();
			}
		});
		
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(new GridBagLayout());
		GUI.Utils.setGridBagConstraints(constraints, 0, 0, 0.5, 0.5, 3, 10);
		
		
		add(_title,constraints);
		
		constraints.gridy = 1;
		add(_closeButton , constraints);
		
	}
	/**
	 * 
	 * @return close JButton reference
	 */
	public JButton getCloseBtn() {return _closeButton; }
	
		
}
