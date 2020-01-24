package GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class GridSquare extends JComponent {
	private DisplaySquare ds;
	private InputSquare is;
	private int type;
	private int index;
	
	/**
	 * 
	 * @param type Integer representing if GridSquare will construct
	 * a DisplaySquare (type = 0) of an InputSquare( type = 1 )
	 * 
	 */
	public GridSquare(int type, int index) {
		this.type = type;
		this.index = index;
	}
	
	public void setSquare(int loVal, int upVal) {
		String loValString = (loVal== -1) ? "" : Integer.toString(loVal);
		String upValString = (upVal== -1) ? "" : Integer.toString(upVal);

		if (this.type==0) this.ds = new DisplaySquare(loValString, upValString);
		else {
			this.is = new InputSquare(this.index);
			this.is.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					
		            if (
		            		(is.getText().length()<=1 && ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
		            		|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		               is.setEditable(true);
		            } else {
		               is.setEditable(false);
		            }
				}
			});
		}
	}
	
	public int getType() { return this.type; }
	
	public int getIndex() {return this.index;}
	
	public DisplaySquare getDs() { return this.ds; }
	
	public InputSquare getIs() { return this.is; }

}
