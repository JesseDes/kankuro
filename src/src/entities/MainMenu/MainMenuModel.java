package entities.MainMenu;

/**
 * 
 * @author Jesse Desmarais 
 * MainMenu model data contains the list of difficutlies currently supported by the application.
 *
 */

public class MainMenuModel {

	private String[] _difficultyList;
	
	/**
	 * constructor Clones difficulty list that is passed to the constructor
	 * @param diffList A list of difficulties supported by the puzzle
	 */
	public MainMenuModel(String[] diffList)
	{
		_difficultyList = diffList.clone();
		
	}
	
	/**
	 * 
	 * Difficulty List getter
	 * @return String array for difficulties
	 */
	public String[] getDifficultyList() { return _difficultyList;}
}
