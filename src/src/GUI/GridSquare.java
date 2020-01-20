package GUI;

import javax.swing.JComponent;

public class GridSquare extends JComponent {
	private DisplaySquare ds;
	private InputSquare is;
	private int type;
	
	/**
	 * 
	 * @param type Integer representing if GridSquare will construct
	 * a DisplaySquare (type = 0) of an InputSquare( type = 1 )
	 * 
	 */
	public GridSquare(int type) {
		this.type = type;
	}
	
	public void setSquare(int loVal, int upVal) {
		String loValString = (loVal== -1) ? "" : Integer.toString(loVal);
		String upValString = (upVal== -1) ? "" : Integer.toString(upVal);

		if (this.type==0) this.ds = new DisplaySquare(loValString, upValString);
		else this.is = new InputSquare();
	}
	
	public int getType() { return this.type; }
	
	public DisplaySquare getDs() { return this.ds; }
	
	public InputSquare getIs() { return this.is; }

}
