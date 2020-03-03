package entities.SampleMVCButton;


public class SampleButtonModel {
	enum ButtonType {
		CLOSE_POP,
		CLOSE_APP
	}
	
	public int id;
	public String text;
	public ButtonType button_type;
	
	public SampleButtonModel(int id, String text, int button_type)
	{
		this.id = id;
		this.text = text;
		//converts int to enum type;
		this.button_type = ButtonType.values()[button_type] ;
	
	}
}
