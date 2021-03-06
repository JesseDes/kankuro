package entities.puzzle;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import GUI.ActionCancelPopup;
import GUI.GridPanel;
import GUI.Label;


/**
 * 
 * @author Antoine Farley
 * @author Marc Hegedus
 * @author Jesse Desmarais
 * Puzzle view contains puzzle grid , buttons for check, undo, reset and leave and load/save prompts
 */

public class PuzzleView extends JPanel {
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridPanel gridbox;
	private JButton checkBtn;
	private JButton undoBtn;
	private JButton resetBtn;
	private JButton closeBtn;
	private ActionCancelPopup loadPrompt;
	private ActionCancelPopup savePrompt;
	
	
	/**
	 * constructor for view. Creates the gridBag constraints and places the grid, buttons and instantiates the prompts
	 * @param model Model Data for the view used to generate grid puzzle
	 */
	public PuzzleView(PuzzleModel model) {
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.setLayout(this.gbl);
		
		//Adding a border to BackPanel()
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		//Instantiating Board label
		Label gridbox_label = new Label(model.getName(), "Calibri", 30);
		
		gridbox = new GridPanel(model);
		
		 this.gbc = new GridBagConstraints();
        this.gbc.fill = GridBagConstraints.HORIZONTAL;
        this.gbc.insets = new Insets(10,0,0,0);

        //Adding the kakuro label
        setGridBagConstraints(0, 0, 0.5, 0.5, 3, 0);
        this.add(gridbox_label, this.gbc);

        //Adding the gridbox
        setGridBagConstraints(0, 1, 0.5, 0.5, 3, 250);
        this.add(gridbox, this.gbc);
        
        checkBtn =  new JButton("CHECK");
        setGridBagConstraints(0, 3, 0.5, 0.5, 1, 30);
        checkBtn.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(checkBtn,this.gbc);
        
        undoBtn =  new JButton("UNDO");
        setGridBagConstraints(1, 3, 0.5, 0.5, 1, 30);
        undoBtn.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(undoBtn , this.gbc);
        
        resetBtn =  new JButton("RESET");
        setGridBagConstraints(2, 3, 0.5, 0.5, 1, 30);
        resetBtn.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(resetBtn, this.gbc);
        
        closeBtn =  new JButton("Main Menu");
        setGridBagConstraints(0, 4, 0.5, 0.5, 3, 30);
        closeBtn.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(closeBtn, this.gbc); 
        
        loadPrompt = new ActionCancelPopup(new Dimension(350,200), "Load previous save?" , "yes" , "no");
        savePrompt = new ActionCancelPopup(new Dimension(350,200), "Save before Quitting?" , "Save" , "Quit");

	}
	
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
     * 
     * @return check JButton reference
     */
    
    public JButton getCheckBtn() {
    	return checkBtn;
    }
    
    /**
     * 
     * @return undo JButton reference
     */    
    
    public JButton getUndoBtn() {
    	return undoBtn;
    }
    /**
     * 
     * @return reset JButton reference
     */
    public JButton getResetBtn() {
    	return resetBtn;
    }
    
    /**
     * 
     * @return close JButton reference
     */
    public JButton getCloseBtn() {
    	return closeBtn;
    }
    
    /**
     * 
     * @return load popup reference
     */    
    
    public ActionCancelPopup displayLoadPrompt() {
    	return loadPrompt;
    }
    
    /**
     * 
     * @return save popup reference
     */   
    public ActionCancelPopup displaySavePrompt() {
    	return savePrompt;
    }
    
    /**
     * 
     * @return gridPanel reference
     */   
    public GridPanel getGridPanel() {
    	return gridbox;
    }

}
