package so.water;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import database.*;
import javafx.event.ActionEvent;
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
	
	@FXML
	public void update(ActionEvent e) throws IOException {
		Station station = new Station(stationNumber.getText(), name.getText(), description.getText());
		new StationsDAO().update(station);
		JFXButton btn = (JFXButton) e.getSource();
		Scene scene = btn.getScene();
		Stage stage = (Stage) scene.getWindow();
		stationController.updateList();
		stage.close();
			
		
	}

	public void selectedStation(Station station, StationsController stationController) {
		name.setText(station.getName());
		stationNumber.setText(station.getStation());
		description.setText(station.getDescription());
		this.stationController = stationController;
	}
	
	@FXML 
	public void cancel(ActionEvent e) throws IOException {
		JFXButton btn = (JFXButton) e.getSource();
		Scene scene = btn.getScene();
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}

}
