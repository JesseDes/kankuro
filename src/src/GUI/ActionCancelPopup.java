package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import core.Application;

public class ActionCancelPopup extends JPanel 
{
	JButton _closeBtn;
	JButton _actionBtn;
	Dimension _size;
	
	public ActionCancelPopup( Dimension size,String popupText , String actionText) 
	{
		_size = size;
		_actionBtn = new JButton(actionText);
		_closeBtn = new JButton("Cancel");
		buildPopup(popupText);

	}
	
	public ActionCancelPopup(Dimension size , String popupText , String actionText, String cancelText)
	{
		_size = size;
		_actionBtn = new JButton(actionText);
		_closeBtn = new JButton(cancelText);
		buildPopup(popupText);
	}
	
	private void buildPopup(String popupText) 
	{
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		GUI.Utils.setGridBagConstraints(constraint, 0, 0, 0.5, 0.5, 1, 10);
		add(new Label(popupText, "Calibri", 30), constraint);
		constraint.gridy = 1;
		add(_closeBtn, constraint);
		constraint.gridx = 1;
		add(_actionBtn, constraint);
	}
	
	public JButton getActionBtn() { return _actionBtn;}
	public JButton getCancelBtn() { return _closeBtn;}
	
	@Override
    public Dimension getPreferredSize() {return _size;}
}
