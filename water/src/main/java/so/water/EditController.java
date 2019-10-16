package so.water;

import java.io.IOException;

import database.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {
	@FXML
	private TextField name;
	@FXML
	private TextField stationNumber;
	@FXML 
	private TextArea description;
	
	private StationsController stationController;
	
	public void update() throws IOException {
		Station station = new Station(stationNumber.getText(), name.getText(), description.getText());
		new StationsDAO().update(station);
		stationController.updateList();
		App.setRoot("stations");
		
	}

	public void selectedStation(Station station, StationsController stationController) {
		name.setText(station.getName());
		stationNumber.setText(station.getStation());
		description.setText(station.getDescription());
		this.stationController = stationController;
	}
	
	public void cancel() throws IOException {
		App.setRoot("stations");
	}

}
