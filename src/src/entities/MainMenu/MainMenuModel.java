package entities.MainMenu;

public class MainMenuModel {

	private String[] _difficultyList;
	private String[] _loadList;
	
	public MainMenuModel(String[] diffList ,  String[] loadData)
	{
		_difficultyList = diffList.clone();
		_loadList = loadData.clone();
		
	}
	
	public String[] getDifficultyList() { return _difficultyList;}
	public String[] getLoadData() {return _loadList;}
}
