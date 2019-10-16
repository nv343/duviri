package so.water;

import java.io.IOException;


import javafx.fxml.FXML;

public class PrimaryController {

	@FXML
	private void load() throws IOException {
		App.setRoot("primary");
	}

	@FXML
	private void switchToInfo() throws IOException {
		App.setRoot("info");
	}
	
	@FXML
	private void switchToMap() throws IOException {
		App.setRoot("map");
	}
	
	@FXML
	private void switchToRadio() throws IOException {
		App.setRoot("radio");
	}
	
	@FXML
	private void switchToPlayer() throws IOException {
		App.setRoot("player");
	}
	
	@FXML
	private void switchToAC() throws IOException {
		App.setRoot("AC");
	}
}
