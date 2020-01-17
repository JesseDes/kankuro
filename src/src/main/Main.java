package main;

import core.*;
import GUI.CloseButton;
public class Main {

	public static void main(String[] args) {
		AppController.getInstance();
		AppModel.getInstance();
		AppView.getInstance();

		
		AppView.getInstance().addToFrame(new CloseButton());
	}

}
