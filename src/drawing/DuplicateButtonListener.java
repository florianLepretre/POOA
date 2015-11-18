package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuplicateButtonListener implements ActionListener {
	
	private Drawing drawing;
	
	public DuplicateButtonListener(Drawing drawing){
		this.drawing = drawing;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		drawing.duplicate();
	}

}
