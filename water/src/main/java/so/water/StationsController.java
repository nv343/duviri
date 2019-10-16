package so.water;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import database.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StationsController implements Initializable{
	
	@FXML
	private JFXListView<Station> StationList;

	public void updateList() {
		StationsDAO dao = new StationsDAO();
		StationList.setItems(null);
		StationList.setItems((ObservableList<Station>) dao.getAll());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateList();
		
	}
	
	@FXML
	public void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
	
	
	public void delete() {
		new StationsDAO().delete(StationList.getSelectionModel().getSelectedItem());
	}
	
	public void save() throws IOException {
		App.setRoot("save");
	}

	public void edit() throws IOException {
		App.setRoot("edit");
		EditController controller = new EditController();
		controller.selectedStation(StationList.getSelectionModel().getSelectedItem(), this);
	}
}
