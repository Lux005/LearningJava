package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MainS extends Application {


	@Override
	public void start(Stage primaryStage1) {
		try {
			//load same fxml for two windows.
			Parent root1 = FXMLLoader.load(getClass().getResource("myView.fxml"));
		
			Scene scene1 = new Scene(root1,400,600);
			
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage1.setScene(scene1);
			primaryStage1.setTitle("Messenger1");
			primaryStage1.setX(100);
			primaryStage1.setY(100);
			primaryStage1.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void update()
	{

	}
	public static void main(String[] args) {
		launch(args);
	}
}
