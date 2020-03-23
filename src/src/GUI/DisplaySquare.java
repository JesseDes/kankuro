package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Antoine Farley
 *Display Square is the Jpanel for each square in the puzzle grid
 */

public class DisplaySquare extends JPanel {
    private final int SIZE = 70;
    private String lowerValue;
    private String upperValue;
    private Polygon lowerTriangle = new Polygon(
            new int[]{0, this.SIZE},
            new int[]{0, this.SIZE},
            2
    );

    /**
     * Constructor for DisplaySquare
     * @param lowerVal Numerical value of the bottom triangle division number in a DisplaySquare
     * @param upperVal Numerical value of the top triange division number in a DisplaySquare
     */
    public DisplaySquare(String lowerVal, String upperVal){
    		this.lowerValue = lowerVal;
    		this.upperValue = upperVal;
            GridLayout grid = new GridLayout(2, 2, 10,10);
            JTextField[] values = new JTextField[2];
            this.setLayout(grid);
            if(this.lowerValue.equals("") && this.upperValue.equals("")){
            	
        	}
            else {
            	int count = 0;
                for (int i = 0; i < 4; i++) {
                    if (i==1 || i == 2) {
                        values[count] = new JTextField(4);
                        values[count].setText((i==1) ? upperVal:lowerVal);
                        values[count].setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        values[count].setHorizontalAlignment(JTextField.CENTER);
                        values[count].setEditable(false);
                        values[count].setBackground(null);
                        values[count].setSize(this.SIZE, this.SIZE);
                        values[count].setFont(new Font("Calibri", Font.BOLD, 16));
                        this.add(values[count++]);
                    }
                    else { this.add(new JLabel()); }
                }
            }
        	if(this.lowerValue.equals("") && this.upperValue.equals(""))
        		setBackground(Color.DARK_GRAY);
        	else
        		setBackground(Color.gray);
    }

/**
 * returns preferred size;
 */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.SIZE, 40);
    }
}
