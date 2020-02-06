package entities.SampleMVCButton;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.*;
import entities.SampleMVCButton.SampleButtonModel.ButtonType;

public class SampleButton implements ActionListener {

	private SampleButtonView _view;
	private SampleButtonModel _data;
	
	public SampleButton(int id)
	{
		_data = Application.getInstance().getModel().getButtonData(id);
		_view = new SampleButtonView(_data.text);
		_view.addActionListener(this);
		Application.getInstance().getView().addPopup(_view);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(_data.button_type == ButtonType.CLOSE_APP)
			Application.getInstance().closeApp();
		else if(_data.button_type == ButtonType.CLOSE_POP)
			Application.getInstance().getView().removePopup();
		
	}
	
}
