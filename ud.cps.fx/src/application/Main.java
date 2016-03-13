package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

class Apple implements IfFruit{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I am a red apple!");
	}

	@Override
	public float getWeight() {
		// TODO Auto-generated method stub
		return 1.12f;
	}

	
}
public class Main extends Application implements EventHandler<ActionEvent>{
	static Label label;
	@Override
	
	public void start(Stage primaryStage) {
		try {
			
			Apple apple=new Apple();
			apple.display();
			
			label=new Label("Hello World");
			
			Button btn = new Button();
			btn.setText("Hello");
			btn.setOnAction(this);//this=class main=>EventHandler
			//btn.setOnAction();
			
			VBox layout = new VBox();
			layout.getChildren().add(btn);
			layout.getChildren().add(label);
			layout.setAlignment(Pos.CENTER);
		
			Scene scene = new Scene(layout,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("Hello World");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		ChoiseWindow.parentButton();
	}
}


