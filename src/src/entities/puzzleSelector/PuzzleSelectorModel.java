package entities.puzzleSelector;

public class PuzzleSelectorModel {

	private String _name;
	private int _id;
	private String _difficulty;
	
	public PuzzleSelectorModel(String name, int id, String difficulty)
	{
		_name = name;
		_id = id;
		_difficulty = difficulty;
	}
	
	public String getName() {return _name;}
	public int getId() { return _id;}
	public String getDifficulty() { return _difficulty;}
}
