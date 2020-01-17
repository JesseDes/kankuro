package GUI;

import javax.swing.*;
import core.AppController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseButton extends JButton{
	public static final String BUTTON_TEXT = "Exit Application";
	
	public CloseButton() {
		this.setText(BUTTON_TEXT);
		
		//on Click event
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppController.getInstance().closeApp();
				
			}
        });
	}
}
