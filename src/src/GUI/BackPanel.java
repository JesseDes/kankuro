package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import core.Application;

public class BackPanel extends JPanel {
	private static BackPanel backPanelInstance;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridPanel gridbox;
	
	public BackPanel() {
		//Instantiating and setting GridBagLayout and GridBagConstraints
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.setLayout(this.gbl);
		
		//Adding a border to BackPanel()
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		//Instantiating Board label
		Label gridbox_label = new Label("BOARD", "Calibri", 30);
		Application.getInstance().getView().addToFrame(gridbox_label);
	
		//Instantiating and populating GridPanel
		//gridbox = new GridPanel();
		
		//Instantiating an array of JButtons 
        JButton[] gamebuttons = { new JButton("CHECK"), new JButton("UNDO"), new JButton("RESET") };

        //Instantiating Difficulty label
        Label difficulty_label = new Label("DIFFICULTY", "Calibri", 20);
        
        //Instantiating difficulty button checkboxes
        JButton[] difficulty = { new JButton("EASY"), new JButton("NORMAL"), new JButton("HARD") };
        addDifficultyLevelButtonListener(difficulty);
        
        //Adding a button for a new game
        JButton newgameButton = new JButton("NEW GAME");
        
	
      //Adding elements with GridBagConstraints
        this.gbc = new GridBagConstraints();
        this.gbc.fill = GridBagConstraints.HORIZONTAL;
        this.gbc.insets = new Insets(10,0,0,0);

        //Adding the kakuro label
        setGridBagConstraints(0, 0, 0.5, 0.5, 3, 0);
        this.add(gridbox_label, this.gbc);

        //Adding the gridbox
        setGridBagConstraints(0, 1, 0.5, 0.5, 3, 250);
        this.add(gridbox, this.gbc);

        //Adding the game buttons and gamebutton listeners
        for (int i = 0; i < gamebuttons.length; i++) {
            setGridBagConstraints(i, 3, 0.5, 0.5, 1, 30);
            gamebuttons[i].setFont(new Font("Calibri", Font.BOLD, 16));
            this.add(gamebuttons[i], this.gbc);
        }
        addGameButtonListeners(gamebuttons);
        

        //Add Difficulty label
        setGridBagConstraints(0, 4, 0.5, 0.5, 3, 20);
        this.add(difficulty_label, this.gbc);

        
        //Add difficulty button selectors
        for (int i = 0; i < difficulty.length; i++) {
            difficulty[i].setBorder(BorderFactory.createLineBorder(UIManager.getColor("Panel.background"), 1));
            difficulty[0].setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            difficulty[0].setForeground(Color.BLUE);
            
            setGridBagConstraints(i, 5, 0.5, 0.5, 1, 50);
            difficulty[i].setFont(new Font("Calibri", Font.BOLD, 16));
            this.add(difficulty[i], this.gbc);
        }
        
        
        //Add new game buton
        setGridBagConstraints(0, 6, 0.5, 0.5, 3, 40);
        newgameButton.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(newgameButton, this.gbc);
        
	}
	
	/**
	 * Static accessor method so that AppModel and AppController can access the BackPanel
	 * @return BackPanel object
	 */
	public static BackPanel getBackPanel() {
    	
    	if(backPanelInstance == null)
    		backPanelInstance = new BackPanel();
    	
    	return backPanelInstance;
	}
	
	/**
	 * Accessor method to return the BackPanel's corresponding GridBox object
	 * @return GridBox object
	 */
	public GridPanel getGridBox() { return getBackPanel().gridbox; }
	
	
	/**
	 * Macro-type function to change gridBagConstraints this.gbc, only contains parameters 
	 * used at least one time in addElementsToFrame
	 * @param gridx
	 * @param gridy
	 * @param weightx
	 * @param weighty
	 * @param gridwidth
	 * @param ipady
	 */
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
    
    
    /**
     * EventListeners associating the game buttons to their corresponding function
     * @param gamebuttons
     */
    public void addGameButtonListeners(final JButton[] gamebuttons){
            gamebuttons[1].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    gridbox.undoLastOperation();
                }
            });
            gamebuttons[2].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    gridbox.clearBoard();
                }
            });
    }	
    
    
    /**
     * EventListener to make the difficulty buttons act as checkboxes
     * @param difficulty Array containing the difficulty buttons
     */
    public void addDifficultyLevelButtonListener(final JButton[] difficulty){
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
