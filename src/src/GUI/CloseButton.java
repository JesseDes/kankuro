package GUI;

import javax.swing.*;
import core.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseButton extends JButton{
	//public static final String BUTTON_TEXT = "Exit Application";
	
	public CloseButton(String buttonText) {
		this.setText(buttonText);
		
		//on Click event
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Application.getInstance().closeApp();
				
			}
        });
	}
}
