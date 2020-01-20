package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class BackPanel extends JPanel {
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridPanel gridbox;
	
	public BackPanel() {
		//Instantiating and setting GridBagLayout and GridBagConstraints
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.setLayout(this.gbl);
		
		//Instantiating Board label
		Label gridbox_label = new Label("BOARD", "Calibri", 30);
	
		//Instantiating and populating GridPanel
		gridbox = new GridPanel();
		
		//Instantiating an array of JButtons 
        JButton[] gamebuttons = { new JButton("CHECK"), new JButton("UNDO"), new JButton("RESET") };

        //Instantiating Difficulty label
        Label difficulty_label = new Label("DIFFICULTY", "Calibri", 20);
        
        //Instantiating difficulty button checkboxes
        JButton[] difficulty = { new JButton("EASY"), new JButton("NORMAL"), new JButton("HARD") };
        difficultyLevelButtonListener(difficulty);
	
      //Adding elements with GridBagConstraints
        this.gbc = new GridBagConstraints();
        this.gbc.fill = GridBagConstraints.HORIZONTAL;
        this.gbc.insets = new Insets(10,0,0,0);

        setGridBagConstraints(0, 0, 0.5, 0.5, 3, 0);
        this.add(gridbox_label, this.gbc);

        setGridBagConstraints(0, 1, 0.5, 0.5, 3, 300);
        this.add(gridbox, this.gbc);

        for (int i = 0; i < gamebuttons.length; i++) {
            setGridBagConstraints(i, 3, 0.5, 0.5, 1, 100);
            gamebuttons[i].setFont(new Font("Calibri", Font.BOLD, 16));
            this.add(gamebuttons[i], this.gbc);
        }
        

        setGridBagConstraints(0, 4, 0.5, 0.5, 3, 0);
        this.add(difficulty_label, this.gbc);

        for (int i = 0; i < difficulty.length; i++) {
            difficulty[i].setBorder(BorderFactory.createLineBorder(UIManager.getColor("Panel.background"), 1));
            difficulty[0].setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            difficulty[0].setForeground(Color.BLUE);

            setGridBagConstraints(i, 5, 0.5, 0.5, 1, 50);
            difficulty[i].setFont(new Font("Calibri", Font.BOLD, 16));
            this.add(difficulty[i], this.gbc);
        }
	}
	
	public GridPanel getGridBox() {
		return this.gridbox;
	}
	
    //Macro-type function to change gridBagConstraints this.gbc, only contains parameters
    //used at least one time in addElementsToFrame
    public void setGridBagConstraints(
            Object gridx, Object gridy, Object weightx, Object weighty,
            Object gridwidth, Object ipady
    ) {
        if (!gridx.equals(-1)){ this.gbc.gridx = (int)gridx; }
        if (!gridy.equals(-1)){ this.gbc.gridy = (int)gridy; }
        if (!weightx.equals(-1)){ this.gbc.weightx = (double)weightx; }
        if (!weighty.equals(-1)){ this.gbc.weighty = (double)weighty; }
        if (!gridwidth.equals(-1)){ this.gbc.gridwidth = (int)gridwidth; }
        if (!ipady.equals(-1)){ this.gbc.ipady = (int)ipady; }
    }
    
    //Makes the difficulty buttons act as checkboxes
    public void difficultyLevelButtonListener(final JButton[] difficulty){
        for (final JButton button: difficulty) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JButton button: difficulty) {
                    	button.setBackground(null);
                        button.setOpaque(true);
                        button.setBorder(BorderFactory.createLineBorder(UIManager.getColor("Panel.background"), 1));
                        button.setForeground(null);
                    }
                    button.setForeground(Color.BLUE);
                    button.setOpaque(false);
                    button.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                    button.setContentAreaFilled(false);
                }
            });
        }
    }	
   
}
