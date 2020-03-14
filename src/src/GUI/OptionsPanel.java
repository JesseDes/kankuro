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
/**
 * 
 * @author Jesse Desmarais
 *Generic JPanel class for a a Jpanel with a list of buttons to choose from
 */
public class OptionsPanel extends JPanel {

	private JButton[] _optionList;
	private Dimension _size;
	
	/**
	 *Constructor sets Jpanel to supplied size , creates label with supplied text and creates JButton for each Option supplied.
	 *Sets up constraints and adds all buttons, text to the JPanel
	 * @param optionList String array for each button where string is used as button text
	 * @param size the length and width of the Panel
	 * @param title the title String for the panel
	 */
	public OptionsPanel(String[] optionList , Dimension size , String title)
	{
		setLayout(new GridBagLayout());
		_size = size;

		GridBagConstraints constraint = new GridBagConstraints();
		GUI.Utils.setGridBagConstraints(constraint, 0, 0, 0.5, 0.5, 3, 20);
		Label optionTitle = new Label(title, "Calibri", 20);
		add(optionTitle, constraint);
		_optionList = new JButton[optionList.length];
		constraint.gridy = 1;

		for(int i = 0 ; i < optionList.length; i++)
		{
			GUI.Utils.setGridBagConstraints(constraint, i, 1, 0.5, 0.5, 1, 20);
			_optionList[i] = new JButton(optionList[i]);
			_optionList[i].setFont(new Font("Calibri", Font.BOLD, 16));
			add(_optionList[i],constraint);
		}
	}
	
	/**
	 * 
	 * @return array for all JButton references
	 */
	public JButton[] getOptions() {return _optionList;}
    
	/**
     * @return supplied size 
     */
	@Override
    public Dimension getPreferredSize() {
        return _size;
    }
}

