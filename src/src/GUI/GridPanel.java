package GUI;

import javax.swing.*;
import core.AppController;
import java.awt.*;


public class GridPanel extends JPanel {
	private GridLayout gridLayout;
	private GridSquare[] gridSquares;

	public GridPanel() {
		//Instantiating and setting up properties
		super();
//		this.setSize(900, 900);
		this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
		this.gridLayout = new GridLayout(9, 9, 4, 4);
		this.setLayout(this.gridLayout);
		
		//Creating and populating GridSquare array (example only)
		this.gridSquares = new GridSquare[81];
		this.populateGridPanel();
		
	}
	
	//Used for example only until AppModel can actually create a game
	public void populateGridPanel() {
		int counter = 0;
        for (GridSquare inputsquares: this.gridSquares) {
            if(counter<9 || counter+1%9==0 || counter-1%9==0 || counter>70){
                inputsquares = new GridSquare(0);
                inputsquares.setSquare(counter++, counter);
            }
            else {
            	inputsquares = new GridSquare(1);
                inputsquares.setSquare(-1, -1);
            }

            this.add((inputsquares.getType()==0) ? inputsquares.getDs() : inputsquares.getIs());
            counter++;
        }
	}
	
	public GridSquare[] getGridSquares() {
		return this.gridSquares;
	}
}
