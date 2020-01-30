package main;

import core.*;
import entities.PuzzleModel;
import entities.SampleMVCButton.SampleButton;
public class Main {

	public static void main(String[] args) {
		System.out.println("IM HERE");
		Application app = Application.getInstance();
		PuzzleModel puzzle = app.getModel().getPuzzleModel(1);

	
	}

}
