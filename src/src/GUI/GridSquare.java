package GUI;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

/**
 * Types 
 * 0 -> Blank display square
 * 1 -> Display Square displaying summation
 * 2 -> Input square
 * 
 * @author Antoine Farley
 * GridSquare that makes up a puzzle. Contains a Display square if grid needs to show sums or is blank or contains an 
 * input square if square is meant to accept user input
 */
public class GridSquare extends JComponent {
	private DisplaySquare ds;
	private InputSquare is;
	private int type;
	private int index;
	
	/**
	 * Constructor for GridSquare
	 * @param type Integer representing if GridSquare will construct
	 * a DisplaySquare (type = 0) of an InputSquare( type = 1 )
	 * 
	 */
	public GridSquare(int type, int index) {
		this.type = type;
		this.index = index;
	}
	
	/**
	 * Instantiates the GridSquare with a DisplaySquare or an InputSquare depending on this.type
	 * @param loVal Numerical value of the bottom triangle division number in a DisplaySquare
	 * @param upVal Numerical value of the top triange division number in a DisplaySquare
	 */
	public void setSquare(int loVal, int upVal) {
		String loValString = (loVal== -1) ? "" : Integer.toString(loVal);
		String upValString = (upVal== -1) ? "" : Integer.toString(upVal);

		if (this.type==0) this.ds = new DisplaySquare(loValString, upValString);
		else {
			this.is = new InputSquare(this.index, loVal);
			this.is.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					
		            if (
		            		(is.getText().length()<=1 && ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
		            		|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		               is.setEditable(true);
		            } else {
		            if ((is.getText().length()<=1 && ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
		            || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		               is.setEditable(true);
		            } 
		            else {
		               is.setEditable(false);
		            }
				}
				}
			});
		}
	}
	
	/**
	 * By ZHOU, actual one by controler
	 * Instantiates the GridSquare with a DisplaySquare or an InputSquare depending on this.type
	 * @param loVal Numerical value of the bottom triangle division number in a DisplaySquare
	 * @param upVal Numerical value of the top triange division number in a DisplaySquare
	 */
	public void setSquare_C(int loVal, int upVal) {
		
		String loValString = (loVal== -1) ? "" : Integer.toString(loVal);
		String upValString = (upVal== -1) ? "" : Integer.toString(upVal);
		
		
		
		if (this.type ==0) { 
			this.ds = new DisplaySquare(loValString, upValString);
		}
		else {
			this.is = new InputSquare(this.index, loVal);
			this.is.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					
		            if (
		            		(is.getText().length()<=1 && ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
		            		|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		               is.setEditable(true);
		            } else {
		            if ((is.getText().length()<=1 && ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
		            || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		               is.setEditable(true);
		            } 
		            else {
		               is.setEditable(false);
		            }
				}
				}
			});
		}
	}
	
	/**
	 * Accessor for this.type
	 * @return Integer representing the type of the square
	 */
	public int getType() { return this.type; }
	
	/**
	 * Accessor for this.index
	 * @return Integer representing the array position of the square in GridPanel
	 */
	public int getIndex() {return this.index;}
	
	/**
	 * Checks if current user inputted value of InputSquare is the right answer
	 * @return true if correct answers, false if not
	 */
	public boolean checkValue() {
		if(this.getType()==1) { return this.getIs().checkValue(); }
		return false;
	}
	
	/**
	 * Accessor for InputSquare object
	 * @return DisplaySquare object of current GridSquare
	 */
	public DisplaySquare getDs() { return this.ds; }
	
	/**
	 * Accessor for InputSquare object
	 * @return InputSquare object of current GridSquare
	 */
	public InputSquare getIs() { return this.is; }

}
