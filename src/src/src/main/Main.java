package main;

import GUI.BackPanel;
import core.*;
import entities.puzzle.*;
import MVC_Control.*;
public class Main {

	public static void main(String[] args) {
		
		Application app = Application.getInstance();
		
		PuzzleModel puzzle = app.getModel().getPuzzleModel(1);

		Control_main C = new Control_main();
		
		//Application.getInstance().getView().addToFrame(BackPanel.getBackPanel());
	
	}

}
