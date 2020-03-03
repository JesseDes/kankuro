package entities.puzzle;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import GUI.GridPanel;
import GUI.GridPanelLoad;
import GUI.Label;


public class PuzzleView extends JPanel {
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private GridPanel gridbox;
	private GridPanelLoad loadTime;
	JButton checkBtn;
	JButton undoBtn;
	JButton resetBtn;
	////////////////////////////////
	JButton saveBtn;
	JButton loadBtn;
	////////////////////////////////
	
	public PuzzleView(PuzzleModel model) {
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.setLayout(this.gbl);
		
		//Adding a border to BackPanel()
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		//Instantiating Board label
		Label gridbox_label = new Label("BOARD", "Calibri", 30);
		
		gridbox = new GridPanel(model);
		loadTime = new GridPanelLoad();
		
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
     
	////////////////////////////////////////////////////////
	
        saveBtn =  new JButton("SAVE");
        setGridBagConstraints(0, 4, 0.5, 0.5, 1, 30);
        saveBtn.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(saveBtn, this.gbc);

        loadBtn =  new JButton("LOAD");
        setGridBagConstraints(1, 4, 0.5, 0.5, 1, 30);
        loadBtn.setFont(new Font("Calibri", Font.BOLD, 16));
        this.add(loadBtn, this.gbc); 
	}
	////////////////////////////////////////////////////////
	
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
    
    
    public JButton getCheckBtn() {
    	return checkBtn;
    }
    
    public JButton getUndoBtn() {
    	return undoBtn;
    }
    
    public JButton getResetBtn() {
    	return resetBtn;
    }
    
    public GridPanel getGridPanel() {
    	return gridbox;
    }
    
    public GridPanelLoad getGridPanelLoad() {
    	return loadTime;
    }
    
    public JButton getSaveBtn() {
    	return saveBtn;
    }

    public JButton getLoadBtn() {
    	return loadBtn;
    }
    
}
