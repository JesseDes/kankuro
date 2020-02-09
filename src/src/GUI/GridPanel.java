package GUI;

import javax.swing.*;

import core.Application;
import entities.puzzle.PuzzleModel;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;


public class GridPanel extends JPanel implements FocusListener {
	private GridLayout gridLayout;
	private GridSquare[] gridSquares;
	private InputSquare inFocusInputSquare;
	private InputSquare outFocusInputSquare;
	private String currentFocusVal;
	private Stack<Integer> operationsStack = new Stack<Integer>();
	
	/**
	 * Constructor for GridPanel by ZHOU
	 * creating 10*10
	 */
	public GridPanel(PuzzleModel data ) {
		//Instantiating and setting up properties
		super();
		this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createMatteBorder(2,3,2,3, Color.BLACK));
		this.gridLayout = new GridLayout(10, 10, 4, 4);
		this.setLayout(this.gridLayout);
		this.currentFocusVal = "";
		
		
		//Creating and populating GridSquare array (example only)
		this.gridSquares = new GridSquare[100];
		this.populateGridPanel(data);	
	}
	

	/**
	 * Removes the text/value in the last edited InputSquare element
	 */
	public void undoLastOperation() {
		if(!operationsStack.isEmpty()) {
			int popelem = operationsStack.pop();
			System.out.println(popelem);
			gridSquares[popelem].getIs().setText("");
			gridSquares[popelem].getIs().setBackground(Color.white);

		}
		
	}
	
	/**
	 * Removes the text/value in all InputSquares elements
	 */
	public void clearBoard() {
		for(GridSquare square: gridSquares) {
			if(square.getType()==1) {
				square.getIs().setText("");
				square.getIs().setBackground(Color.white);
			}
		}
	}
	
	/**
	 * FocusGained eventListener for the current InputSquare
	 */
	public void focusGained(FocusEvent e) {
//        System.out.println("Focus gained" + e.toString());
                
        //Assigning current inFocus component to InputSquare variable
        inFocusInputSquare = ((InputSquare) e.getSource());
        
        //Recording current value of input to add to OperationsStack if changed on outFocus
        this.currentFocusVal = inFocusInputSquare.getText();
        
        //Changing border color of inFocus element to Blue
        inFocusInputSquare.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
    }
	
	/**
	 * FocusGained eventListener for the current InputSquare
	 */
    public void focusLost(FocusEvent e) {
//        System.out.println("Focus lost" + e.toString());
        
        //Adding the index of the last InputSquare on the operations stack if input changed
        if(!this.currentFocusVal.equals(inFocusInputSquare.getText())) {
        	this.operationsStack.push(inFocusInputSquare.getIndex());
        	System.out.println(this.operationsStack.toString());
        }
        
        //Recording current value of output
        outFocusInputSquare = ((InputSquare) e.getSource());
        
        outFocusInputSquare.checkValue();
        
        //Changing border color of outFocus element to Black
        inFocusInputSquare.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        
    }
	
	public boolean isSolved()
    {
    	boolean result = true;
    	for(int i = 0; i < gridSquares.length; i++)
    	{
    		if(gridSquares[i].getType() == 1 && !gridSquares[i].checkValue())
    		{
    			result = false;
    			break;
    		}
    	}
    	
    	return result;
    }
	
	//used for example with AppModel by ZHOU
	public void populateGridPanel(PuzzleModel puzzleArr ) {
		for (int i = 0; i< puzzleArr.getPuzzleGridSize(); i++) {
			if(puzzleArr.getType(i) != 2){
                gridSquares[i] = new GridSquare(0, i);
                gridSquares[i].setSquare_C(puzzleArr.getUpVal(i), puzzleArr.getLoVal(i));
            	
            }
            else {
            	gridSquares[i] = new GridSquare(1, i);
            	gridSquares[i].setSquare_C(puzzleArr.getLoVal(i), puzzleArr.getUpVal(i));
            	gridSquares[i].getIs().addFocusListener(this);
            }
            this.add((gridSquares[i].getType()==0) ? gridSquares[i].getDs() : gridSquares[i].getIs());

		}
	}

}
