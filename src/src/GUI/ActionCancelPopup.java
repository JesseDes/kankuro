package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import core.Application;

/**
 * A generalize popup class, containting some text and two buttons. A generalized action button and generalized cancel button
 * @author Jesse Desmarais
 *
 */
public class ActionCancelPopup extends JPanel 
{
	JButton _closeBtn;
	JButton _actionBtn;
	Dimension _size;
	
	/**
	 * Constructor builds the popup with default cancel text for cancel button
	 * @param size width and length size of popuup
	 * @param popupText the text message of the popup
	 * @param actionText the text of the action button
	 */
	public ActionCancelPopup( Dimension size,String popupText , String actionText) 
	{
		_size = size;
		_actionBtn = new JButton(actionText);
		_closeBtn = new JButton("Cancel");
		buildPopup(popupText);

	}
	
	/**
	 * Constructor that builds the popup with provided cancel text
	 * @param size Length and Width of popup
	 * @param popupText the text of the popup
	 * @param actionText the text of the action button
	 * @param cancelText the text of the cancel button
	 */
	public ActionCancelPopup(Dimension size , String popupText , String actionText, String cancelText)
	{
		_size = size;
		_actionBtn = new JButton(actionText);
		_closeBtn = new JButton(cancelText);
		buildPopup(popupText);
	}
	
	/**
	 * sets up the layout and constraints for the JPanel and adds the button and text
	 * @param popupText the popups text passed down from the constructor
	 */
	private void buildPopup(String popupText) 
	{
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		GUI.Utils.setGridBagConstraints(constraint, 0, 0, 0.5, 0.5, 3, 10);
		constraint.gridx = 0;
		constraint.fill = constraint.HORIZONTAL;
		constraint.insets = new Insets(0,30,0,30);
		add(new Label(popupText, "Calibri", 30), constraint);
		GUI.Utils.setGridBagConstraints(constraint, 0, 1, 0.5, 0.5, 1, 10);

		add(_closeBtn, constraint);
		GUI.Utils.setGridBagConstraints(constraint, 1, 1, 0.5, 0.5, 1, 10);

		add(_actionBtn, constraint);
	}
	/**
	 * 
	 * @return returns action JButton reference
	 */
	public JButton getActionBtn() { return _actionBtn;}
	/**
	 * 
	 * @return returns cancel JButton reference
	 */
	public JButton getCancelBtn() { return _closeBtn;}
	/**
	 * 
	 * @return preferred size as set in constructor
	 */
	@Override
    public Dimension getPreferredSize() {return _size;}
}
