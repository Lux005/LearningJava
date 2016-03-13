package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {


	@Override
	public void start(Stage primaryStage1) {
		try {
			Stage primaryStage2 = new Stage();
			//load same fxml for two windows.
			Parent root1 = FXMLLoader.load(getClass().getResource("myView.fxml"));
			Parent root2 = FXMLLoader.load(getClass().getResource("myView.fxml"));
			
			Scene scene1 = new Scene(root1,400,600);
			Scene scene2 = new Scene(root2,400,600);
		
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage1.setScene(scene1);
			primaryStage1.setTitle("Messenger1");
			primaryStage1.setX(100);
			primaryStage1.setY(100);
			
			primaryStage2.setScene(scene2);
			primaryStage2.setTitle("Messenger2");
			primaryStage2.setX(600);
			primaryStage2.setY(100);
			
			primaryStage1.show();
			primaryStage2.show();

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
