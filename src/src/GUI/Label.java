package GUI;

import java.awt.*;
import javax.swing.*;

public class Label extends JLabel {

	public Label(String name, String fontName, int fontSize) {
		super(name, SwingConstants.CENTER);
		this.setFont(new Font(fontName, Font.BOLD, fontSize));
	}
}
