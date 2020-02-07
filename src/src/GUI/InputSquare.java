package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class InputSquare extends JTextField {
	private int index;
	private int correctValue;
	
	/**
	 * Constructor for InputSquare
	 * @param index Integer representing the array index of the square's position in GridPanel
	 * @param correctValue Integer representing the correct value (puzzle answer) of the current square
	 */
	public InputSquare(int index, int correctValue) {
		super(4);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.setFont(new Font("Calibri", Font.BOLD, 16));
		this.index = index;
		this.correctValue = correctValue;
	}
	
	/**
	 * Accessor for this.index
	 * @return Integer representing the array index of the square's position in GridPanel
	 */
	public int getIndex() { return this.index; }
	
	/**
	 * Accessor for this.correstValue
	 * @return Integer representing the correct value (answer) of the current square
	 */
	public int getCorrectValue() { return this.correctValue; }

	/**
	 * Returns the current user inputted value of current square
	 * @return Integer representing the current value, returns -1 if empty
	 */
	public int getCurrentValue() { 
		if(!this.getText().equals("")) {
			return (int)Integer.valueOf(this.getText()); 
		}
		else {
			return -1;
		}
	}

	/**
	 * Setter for this.correctValue
	 * @param value Integer representing the correct value (puzzle answer) of the current square
	 */
	public void setCorrectValue(int value) { this.correctValue = value; }
	
	
	/**
	 * Checks the current value with the accepted answer for this square, changes the square's 
	 * color to green if valid, red if invalid, and white if empty (i.e. user deleted the value)
	 * @return true if valid answer, false if not
	 */
	public boolean checkValue() { 
		boolean res = this.getCorrectValue()==this.getCurrentValue();
		if (this.getCurrentValue()==-1) {
			this.setBackground(Color.white);
			return false;
		}
		if(res) {
			this.setBackground(Color.green);
		}
		else {
			this.setBackground(Color.red);

		}
		return res;
	}
	
}
