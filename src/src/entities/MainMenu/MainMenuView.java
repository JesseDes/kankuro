package entities.MainMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.Label;

/**
 * 
 * @author Jesse Desmarais
 * View for the main menu Contains 2 buttons new Puzzle and Exit application.
 *
 */
public class MainMenuView extends JPanel {
	
	private JButton _newBtn;
	private JButton _closeBtn;
	private GridBagConstraints _constraint;
	
	/**
	 * Constructor builds layout and adds buttons to the Jpanel
	 */
	public MainMenuView()
	{
		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(Color.white);
		
		this.setLayout(new GridBagLayout());
		_constraint = new GridBagConstraints();
		_constraint.ipady = 30;
		_constraint.insets = new Insets(30,0,0,0);
		
		Label title = new Label("KAKURO", "Calibiri" , 30);
		this.add(title);
		
		_newBtn = new JButton("New Puzzle");
		_constraint.gridy = 1;
		_closeBtn = new JButton("Exit Game");
		this.add(_newBtn,_constraint);
		
		_constraint.gridy = 2;
		this.add(_closeBtn,_constraint);
		
	} 	
	/**
	 * @return new Puzzle JButton reference
	 */
	public JButton getNewButton() { return _newBtn;}
	
	/**
	 * 
	 * @return close App Jbutton reference
	 */
	public JButton getCloseButton() { return _closeBtn;}

	/**
	 * ovveride paintCompnent for JPanel to paint the background image
	 */
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    BufferedImage bgImage;
		try {
			bgImage = ImageIO.read(new File("img/background.png"));
		    g.drawImage(bgImage.getScaledInstance(800, 600, Image.SCALE_FAST), 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
