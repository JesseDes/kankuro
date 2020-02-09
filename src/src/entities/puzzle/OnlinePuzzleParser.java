package entities.puzzle;


import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
/*
This script rips puzzles from the internet and converts to our data format
*/


public class OnlinePuzzleParser {
	
	private Elements rows;
	
	public OnlinePuzzleParser() {
		try {
			Document doc = Jsoup.connect("http://www.menneske.no/kakuro/eng/utskrift.html?number=122870").get();
			Elements elem = doc.getElementsByClass("kakurotablegrey");
			Element firstclass = elem.first();
			Element tbody = firstclass.child(0);
			this.rows = tbody.children();
		}
		catch(Exception e) {}
	}
	
	public OnlinePuzzleParser(int dataBaseIdRef) {
		try {
			Document doc = Jsoup.connect("http://www.menneske.no/kakuro/eng/utskrift.html?number=" + Integer.toString(dataBaseIdRef)).get();
			Elements elem = doc.getElementsByClass("kakurotablegrey");
			Element firstclass = elem.first();
			Element tbody = firstclass.child(0);
			this.rows = tbody.children();
		}
		catch(Exception e) {}
	}
	
	public void traverse(int[][] elements) {
		Elements cols;
		int counter = 0;
		for(Element row: this.rows) {
//			System.out.println("Row: " + counter++);
			cols = row.children();
			for(Element col: cols) {
				addGridElement(elements, counter++, col);
//				System.out.println("	Col: " + countercols++ + col + "\n\n");
			}
		}
	}
	
	public void addGridElement(int[][] puzzleGrid, int index, Element elem) {
		if(elem.className().equals("infocellgrey")){
			Elements rows = elem.child(0).child(0).children();
			int eleme[] = new int[3];
			eleme[0] = 0;
			for(int i = 0; i < 2; i++) {
				String t1 = (rows.get(i).child(0).text().toString() + rows.get(i).child(1).text().toString()).replaceAll("\\D+","");
//				System.out.println(t1);
				eleme[2-i] = (t1.equals("")) ? -1 : Integer.parseInt(t1);
			}
			puzzleGrid[index] = eleme;
		}
		else if(elem.className().equals("whitegrey")) {
			puzzleGrid[index] = new int[] {1, -1, -1};

		}
		else if(elem.className().equals("grey")){
			puzzleGrid[index] = new int[] {0, -1, -1};
		}

				
	}
	
}
