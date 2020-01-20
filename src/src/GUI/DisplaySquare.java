package GUI;

import javax.swing.*;
import java.awt.*;

public class DisplaySquare extends JPanel {
    private final int SIZE = 70;
    private Polygon lowerTriangle = new Polygon(
            new int[]{0, this.SIZE},
            new int[]{0, this.SIZE},
            2
    );

    public DisplaySquare(String lowerVal, String upperVal){
            GridLayout grid = new GridLayout(2, 2,10,10);
            JTextField[] values = new JTextField[2];
            this.setLayout(grid);
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
                    values[count].setFont(new Font("Calibri", Font.BOLD, 12));
                    this.add(values[count++]);
                }
                else { this.add(new JLabel()); }
            }

    }

    @Override
    protected void paintComponent(Graphics g){
            super.setBackground(Color.gray);
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawPolygon(this.lowerTriangle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.SIZE, 40);
    }
}
