package entities.puzzleSelector;

/**
 * 
 * @author Jesse Desmarais
 * Model for PuzzleSelector data contains name , id and difficulty for the puzzle
 */
public class PuzzleSelectorModel {

	private String _name;
	private int _id;
	private String _difficulty;
	
	/**
	 * Constructor creates model storing puzzleSelectors needed information
	 * @param name of the puzzle
	 * @param id of the puzzle;
	 * @param difficulty of the puzzle
	 */
	public PuzzleSelectorModel(String name, int id, String difficulty)
	{
		_name = name;
		_id = id;
		_difficulty = difficulty;
	}
	
	/**
	 * 
	 * @return puzzle name
	 */
	public String getName() {return _name;}
	/**
	 * 
	 * @return puzzle Id
	 */
	public int getId() { return _id;}
	/**
	 * 
	 * @return puzzle difficulty
	 */
	public String getDifficulty() { return _difficulty;}
}
