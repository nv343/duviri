package so.water;

import java.io.IOException;

import database.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SaveController {
	@FXML
	private TextField name;
	@FXML
	private TextField stationNumber;
	@FXML 
	private TextArea description;
	
	public void register() throws IOException {
		Station station = new Station(stationNumber.getText(), name.getText(), description.getText());
		new StationsDAO().add(station);
		App.setRoot("stations");
	}
	
	public void cancel() throws IOException {
		App.setRoot("stations");
	}

}
