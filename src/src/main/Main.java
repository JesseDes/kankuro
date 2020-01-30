package main;

import core.*;
import entities.SampleMVCButton.SampleButton;
public class Main {

	public static void main(String[] args) {
		Application.getInstance();

		new SampleButton(1);
		new SampleButton(2);
	}

}
