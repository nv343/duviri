package so.water;

import java.io.IOException;

import com.jfoenix.controls.JFXToggleButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ACController {
	
	@FXML
	Label label;
	
	@FXML
	public void hot() {
		label.setText(Integer.toString(Integer.parseInt(label.getText())+1));
	}
	
	@FXML
	public void cold() {
		label.setText(Integer.toString(Integer.parseInt(label.getText())-1));
	}
	
	@FXML
	public void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
	
	
}
