package entities.puzzleSelector;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import GUI.Label;
import GUI.Utils;

/**
 * View for puzzle Selector contains a scrollable panel that is loaded with preview image of the puzzle
 * and a button that contains the text "Play " + name
 * @author Jesse Desmarais
 *
 */

public class PuzzleSelectorView extends JPanel 
{
	
	private JButton[] _buttonList;
	
	
	public PuzzleSelectorView(PuzzleSelectorModel[] puzzleList) throws IOException
	{
		JPanel buttonListPanel = new JPanel();
		buttonListPanel.setLayout(new GridBagLayout());
		GridBagConstraints cost = new GridBagConstraints();
		cost.ipady = 20;

		Dimension size = new Dimension(450,500);
		_buttonList = new JButton[puzzleList.length];
		this.setPreferredSize(size);
		
		//for each puzzle fetch the image and add a button
		for(int i =0 ; i < puzzleList.length;i++)
		{
			BufferedImage myPicture = ImageIO.read(new File("img/" + puzzleList[i].getName()+".PNG"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(300, 300, Image.SCALE_FAST)));
			Label textLabel = new Label(puzzleList[i].getName() , "Calibri" , 20);
			
			JButton button = new JButton("Play " + puzzleList[i].getName());
			button.setPreferredSize(new Dimension(150,20));
			buttonListPanel.add(textLabel, cost);
			cost.gridy += 100;
			buttonListPanel.add(picLabel,cost);
			cost.gridy += 100;
			buttonListPanel.add(button, cost);
			cost.gridy += 100;
			buttonListPanel.add(Box.createRigidArea(new Dimension(0,30)),cost);
			cost.gridy += 100;
			
			_buttonList[i] = button;
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane(buttonListPanel);
		scrollPane.setPreferredSize(new Dimension((int)size.getWidth() - 15 , (int)size.getHeight() - 15));
		this.add(scrollPane);
	}
	
	/**
	 * 
	 * @return list of puzzle play JButtons
	 */
	JButton[] getButtonList() { return _buttonList;}
}
