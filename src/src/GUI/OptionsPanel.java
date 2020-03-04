package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class OptionsPanel extends JPanel {

	private JButton[] _optionList;
	private Dimension _size;
	
	public OptionsPanel(String[] optionList , Dimension size , boolean isVertical )
	{
		
		setLayout(new GridBagLayout());
		_optionList = new JButton[optionList.length];
		setBackground(Color.BLUE);
		_size = size;
		JPanel buttonList = new JPanel();
		
		for(int i = 0 ; i < optionList.length; i++)
		{
			_optionList[i] = new JButton(optionList[i]);
			_optionList[i].setBorder(BorderFactory.createLineBorder(UIManager.getColor("Panel.background"), 1));
			_optionList[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
			_optionList[i].setForeground(Color.BLUE);
			_optionList[i].setFont(new Font("Calibri", Font.BOLD, 16));
			buttonList.add(_optionList[i]);
		}
		JScrollPane scrollPane = new JScrollPane(buttonList);
		scrollPane.setPreferredSize(new Dimension((int)_size.getWidth() - 15 , (int)_size.getHeight() - 15));
		this.add(scrollPane);
	}
	
	public JButton[] getOptions() {return _optionList;}
    
	@Override
    public Dimension getPreferredSize() {
        return _size;
    }
}

