package so.water;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
	@FXML
	private void load() throws IOException {
		App.setRoot("primary");
	}

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("test");
	}
	
	@FXML
	private void switchToInfo() throws IOException {
		App.setRoot("info");
	}
}
