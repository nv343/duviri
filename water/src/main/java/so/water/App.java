package so.water;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import database.Conn;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private Timer timer;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("loading"));
		stage.setScene(scene);
		stage.show();
		timer.start();
		
		
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	@Override
	public void stop() throws Exception {
		Conn.closeConn();
		super.stop();
	}

}