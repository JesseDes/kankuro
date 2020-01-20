package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class InputSquare extends JTextField {
	public InputSquare() {
		super(4);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.setFont(new Font("Calibri", Font.BOLD, 12));
	}
}
