package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
			Parent homeRoot = homeLoader.load();
			Scene homeScene = new Scene(homeRoot, 700, 850);
			HomeController homeController = homeLoader.getController();
			String documentBase = getHostServices().getDocumentBase();
			Model.setHomeController(homeController);
			Model.setHomeScene(homeScene);
			Model.setDocumentBase(documentBase);

			// homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(homeScene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
