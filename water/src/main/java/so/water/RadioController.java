package so.water;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RadioController {
	
	@FXML
	Label label;

	@FXML
	public void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
	
	@FXML
	public void next() {
		label.setText(Integer.toString(Integer.parseInt(label.getText())+1));
	}
	
	@FXML
	public void previous() {
		label.setText(Integer.toString(Integer.parseInt(label.getText())-1));
	}
}
