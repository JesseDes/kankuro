package test;

import org.junit.Assert;
import org.junit.Test;
import core.AppModel;
import entities.MainMenu.MainMenuModel;
public class MainMenuModelTest {

	/**
	 * @author Jesse Desmarais
	 * Tests the main menu model parses and stores difficulties correctly
	 */
	@Test
	public void ModelTest() {
		String[] expectedDifficutlties = {"Easy", "Medium", "Hard"};
		
		AppModel app = new AppModel();
		MainMenuModel testedModel = new MainMenuModel(app.getdifficulties());
		
		Assert.assertArrayEquals(expectedDifficutlties, testedModel.getDifficultyList());
		
	}
}
