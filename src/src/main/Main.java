package main;

import GUI.BackPanel;
import core.*;
import entities.puzzle.*;
public class Main {

	public static void main(String[] args) {
		
		Application app = Application.getInstance();
		
		PuzzleModel puzzle = app.getModel().getPuzzleModel(1);

		Application.getInstance().getView().addToFrame(BackPanel.getBackPanel());
	
	}

}
