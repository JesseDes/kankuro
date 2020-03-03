package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.Application;

public class TextPopup extends JPanel {

	
	
	public TextPopup(String popupText)
	{
		
		JButton closeButton = new JButton("Close Popup");
		
		closeButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Application.getInstance().getView().removePopup();
			}
		});
		
		this.add(new Label(popupText, "Calibri", 30));
		this.add(closeButton);
		
	}
}
