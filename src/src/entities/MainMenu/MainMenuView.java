package entities.MainMenu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.Label;
import GUI.Utils;


public class MainMenuView extends JPanel {
	
	private JButton _newBtn;
	private JButton _closeBtn;
	private GridBagConstraints _constraint;
	
	public MainMenuView()
	{
		this.setLayout(new GridBagLayout());
		_constraint = new GridBagConstraints();
		_constraint.insets = new Insets(0,10,0,0);
		Label title = new Label("KAKURO", "Calibiri" , 30);
		this.add(title);
		_constraint.gridy = 5;
		//Utils.setGridBagConstraints(_constraint, 0, 5, 0.5, 0.5, 1, 50);
		_newBtn = new JButton("New Puzzle");
		_closeBtn = new JButton("Exit Game");
		this.setPreferredSize(new Dimension(800,600));
		this.add(_newBtn,_constraint);
		_constraint.gridy = 10;
		this.add(_closeBtn,_constraint);
	}
	
	public JButton getNewButton() { return _newBtn;}
	public JButton getCloseButton() { return _closeBtn;}


}
