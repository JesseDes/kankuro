package MVC_Control;

import GUI.BackPanel;
import core.*;
import entities.puzzle.*;
import java.util.Scanner;

public class Control_main {
	
	Application app = null;
	
	
	//default constructor
	public Control_main() {
		
		System.out.println("Control start");
		if (this.app == null)
		this.app = Application.getInstance();
		

		System.out.println("Please choose the puzzle number. (1 is the default)");
		
		//choose puzzle in console
		
		Scanner sc = new Scanner(System.in);
		int Pid = 1;
		do {
		Pid = sc.nextInt();
		System.out.println(Pid);
		if(Pid <0) {
			System.out.println("invalided input. \n Please input an int >= 0");
		}
		}while (Pid < 0);
		sc.close();
		
		
		int[][] tt = this.getmodel(Pid).getSolution();
		for(int i =0; i<tt.length;i++) {
			System.out.print("[ ");
			for (int j = 0; j<3;j++) {
				System.out.print(tt[i][j] + " ");
				
			}
			System.out.println(" ]");
		}//console out of the array
		
		//Application.getInstance().getView().addToFrame(BackPanel.getBackPanel());
		Application.getInstance().getView().addToFrame(BackPanel.getBackPanel(this.getmodel(Pid).getSolution()));
		
		
		
	}
	

	//get the puzzle
	public PuzzleModel getmodel(int i) {
		return this.app.getModel().getPuzzleModel(i);
	}
	
	//getting default puzzle
	public PuzzleModel getmodel() {
		return this.app.getModel().getPuzzleModel(1);
	}
	

}
