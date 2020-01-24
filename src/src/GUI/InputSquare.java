package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class InputSquare extends JTextField {
	private int index;
	
	public InputSquare(int index) {
		super(4);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.setFont(new Font("Calibri", Font.BOLD, 16));
		this.index = index;
	}
	
	public int getIndex() { return this.index; }
}
