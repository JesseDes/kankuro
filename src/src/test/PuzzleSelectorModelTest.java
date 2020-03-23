package test;

import org.junit.Assert;
import org.junit.Test;
import core.AppModel;
import entities.puzzleSelector.PuzzleSelectorModel;

/**
 * 
 * @author Jesse Desmarais
 *Tests to make sure puzzleSelectorModel contains and parses correct information
 */

public class PuzzleSelectorModelTest {

	@Test
	public void PuzzleSelectorTest()
	{
		AppModel app = new AppModel();
		int expectedCount = 3;
		int[] expectedIdList = {1, 2, 7};
		String expectedName = "Easy "; // we will add number as we iterate
		String expectedDifficulty = "Easy";
		
		PuzzleSelectorModel[] selectorModel = app.getPuzzleList("Easy");
		
		Assert.assertEquals(expectedCount, selectorModel.length);
		
		for(int i = 0 ; i < expectedCount; i ++)
		{
			Assert.assertEquals(expectedIdList[i], selectorModel[i].getId());
			Assert.assertEquals(expectedName + "" + (i+1) , selectorModel[i].getName());
			Assert.assertEquals(expectedDifficulty, selectorModel[i].getDifficulty());

		}
	}
}
