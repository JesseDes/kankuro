package main;

import core.*;
import GUI.*;

public class Main {

	public static void main(String[] args) {
//		AppController.getInstance();
//		AppModel.getInstance();
		AppView.getInstance();

		// Creating BackPanel
		BackPanel main = new BackPanel();

		AppView.getInstance().addToFrame(main);
		AppView.getInstance().makeLive();
//		AppView.getInstance().addToFrame(new CloseButton());
	}

}
