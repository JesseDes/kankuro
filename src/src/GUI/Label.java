package GUI;

import java.awt.*;
import javax.swing.*;

public class Label extends JLabel {

	/**
	 * Constructor for custom Label class
	 * @param name String reprenting the text to be displayed by label
	 * @param fontName String representing the name of the font to be used
	 * @param fontSize Integer representing the font size to be used
	 */
	public Label(String name, String fontName, int fontSize) {
		super(name, SwingConstants.CENTER);
		this.setFont(new Font(fontName, Font.BOLD, fontSize));
	}
}
