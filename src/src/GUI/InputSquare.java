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
	
	public InputSquare(int index, int correctValue) {
		super(4);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.setFont(new Font("Calibri", Font.BOLD, 16));
		this.index = index;
		this.correctValue = correctValue;
	}
	
	public int getIndex() { return this.index; }
	
	public int getCorrectValue() { return this.correctValue; }

	public int getCurrentValue() { return (int)Integer.valueOf(this.getText()); }

	public void setCorrectValue(int value) { this.correctValue = value; }
	
	public boolean checkValue() { return (this.getCorrectValue()==this.getCurrentValue()); }
	
}
