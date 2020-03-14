package test;


import org.junit.Assert;
import org.junit.Test;
import entities.puzzle.PuzzleModel;
import core.AppModel;
/**
 * 
* @author Marc Hegedus
* @author Yaroslav Bilodid
 *
 */
public class PuzzleModelTest {
	

	/**
	 *Test if the ApplicationModel is returning a valid puzzleModel. 
	 *Compare exected solution array to 
	 */
	@Test
	public void testPuzzleModelNoSave() {
		
		int[][] expectedSolution = {{0, -1, -1}, {0, -1, -1}, {1, -1, 29}, {1, -1, 3}, {0, -1, -1}, {0, -1, -1}, {0, -1, -1}, {1, -1, 17}, {1, -1, 16}, {1, -1, 4}, {0, -1, -1}, {1, 9, -1}, {2, 8, 0}, {2, 1, 0}, {0, -1, -1}, {1, -1, 3}, {1, 19, 38}, {2, 9, 0}, {2, 7, 0}, {2, 3, 0}, {0, -1, -1}, {1, 11, 4}, {2, 9, 0}, {2, 2, 0}, {1, 26, 21}, {2, 2, 0}, {2, 6, 0}, {2, 8, 0}, {2, 9, 0}, {2, 1, 0}, {1, 8, -1}, {2, 3, 0}, {2, 5, 0}, {1, 10, 23}, {2, 2, 0}, {2, 1, 0}, {2, 7, 0}, {1, -1, 23}, {0, -1, -1}, {0, -1, -1}, {1, 19, -1}, {2, 1, 0}, {2, 7, 0}, {2, 6, 0}, {2, 5, 0}, {1, 11, -1}, {2, 5, 0}, {2, 6, 0}, {0, -1, -1}, {0, -1, -1}, {0, -1, -1}, {0, -1, -1}, {1, 12, -1}, {2, 8, 0}, {2, 4, 0}, {1, 17, -1}, {2, 9, 0}, {2, 8, 0}, {1, -1, 29}, {1, -1, 4}, {0, -1, -1}, {0, -1, -1}, {1, 10, -1}, {2, 9, 0}, {2, 1, 0}, {1, 18, 16}, {2, 3, 0}, {2, 9, 0}, {2, 5, 0}, {2, 1, 0}, {0, -1, -1}, {1, -1, 17}, {1, -1, 4}, {1, 23, 16}, {2, 6, 0}, {2, 9, 0}, {2, 8, 0}, {1, 11, 3}, {2, 8, 0}, {2, 3, 0}, {1, 28, -1}, {2, 8, 0}, {2, 1, 0}, {2, 9, 0}, {2, 3, 0}, {2, 7, 0}, {1, 10, -1}, {2, 1, 0}, {2, 9, 0}, {0, -1, -1}, {1, 19, -1}, {2, 9, 0}, {2, 3, 0}, {2, 7, 0}, {0, -1, -1}, {0, -1, -1}, {1, 9, -1}, {2, 2, 0}, {2, 7, 0}, {0, -1, -1}};
		int expectedId = 1;
		String expectedName = "Easy 1";
		boolean expectedHasSave =false;
		
		AppModel appmodel = new AppModel();
		PuzzleModel puzzle = appmodel.getPuzzleModel(expectedId);
		
		Assert.assertArrayEquals(puzzle.getSolution(), expectedSolution);
		Assert.assertEquals(expectedId, puzzle.getId());
		Assert.assertEquals(expectedName, puzzle.getName());
		Assert.assertEquals(expectedHasSave,puzzle.hasSave());
	}
	/**
	 * Tests to see if Application Model returns valid puzzleModel when save data is present
	 */
	@Test
	public void testPuzzleModelWithSave()
	{
		int[][] expectedSolution = {{0,-1,-1},{0,-1,-1},{1,-1,45},{1,-1,16},{1,-1,13},{0,-1,-1},{0,-1,-1},{1,-1,14},{1,-1,45},{0,-1,-1},{0,-1,-1},{1,21,-1},{2,6,0},{2,7,0},{2,8,0},{1,-1,14},{1,7,9},{2,6,0},{2,1,0},{1,-1,14},{0,-1,-1},{1,38,16},{2,2,0},{2,9,0},{2,5,0},{2,1,0},{2,3,0},{2,8,0},{2,4,0},{2,6,0},{1,11,-1},{2,7,0},{2,4,0},{0,-1,-1},{1,11,10},{2,5,0},{2,6,0},{1,11,5},{2,3,0},{2,8,0},{1,12,-1},{2,9,0},{2,3,0},{1,14,3},{2,6,0},{2,8,0},{1,10,9},{2,1,0},{2,9,0},{0,-1,-1},{0,-1,-1},{1,13,-1},{2,7,0},{2,2,0},{2,4,0},{1,11,15},{2,1,0},{2,4,0},{2,6,0},{1,-1,7},{0,-1,-1},{1,6,11},{2,5,0},{2,1,0},{1,17,7},{2,9,0},{2,8,0},{1,14,-1},{2,8,0},{2,6,0},{1,4,-1},{2,3,0},{2,1,0},{1,10,8},{2,6,0},{2,4,0},{1,-1,10},{1,3,16},{2,2,0},{2,1,0},{1,39,-1},{2,8,0},{2,9,0},{2,3,0},{2,1,0},{2,2,0},{2,4,0},{2,7,0},{2,5,0},{0,-1,-1},{0,-1,-1},{1,13,-1},{2,8,0},{2,5,0},{0,-1,-1},{1,22,-1},{2,6,0},{2,9,0},{2,7,0},{0,-1,-1}};
		int expectedId = 2;
		String expectedName = "Easy 2";
		boolean expectedHasSave = true;
		String[] expectedSaveData = {"-","-","-","-","-","-","-","-","-","-","-","-","5","4","3","-","-","","","-","-","-","","","","","","","","","-","","","-","-","","","-","","","-","","","-","","","-","","","-","-","-","","","","-","","","","-","-","-","","","-","","","-","","","-","","","-","","","-","-","","","-","","","","","","","","","-","-","-","","","-","-","","","","-"};
		
		AppModel appmodel = new AppModel();
		PuzzleModel puzzle = appmodel.getPuzzleModel(expectedId);
	
		
		Assert.assertArrayEquals(puzzle.getSolution(), expectedSolution);
		Assert.assertEquals(expectedId, puzzle.getId());
		Assert.assertEquals(expectedName, puzzle.getName());
		Assert.assertEquals(expectedHasSave,puzzle.hasSave());
		Assert.assertArrayEquals(puzzle.getSaveData(), expectedSaveData);
	}
}
