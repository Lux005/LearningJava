package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
//import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChoiseWindow{
	static Stage stage;
	static public void parentButton() {
		stage= new Stage();
		stage.setTitle("Choise Selection");
		stage.setWidth(250);
		stage.setHeight(200);
		stage.initModality(Modality.APPLICATION_MODAL);//bind this win to its parent
		
		Label label=new Label("Select:");

		ChoiceBox<String> cBox=new ChoiceBox<>();
		cBox.getItems().setAll("Item1","Item2","Item3","Item4");
		
		Button btn1 = new Button();
		btn1.setText("Noodle");
		btn1.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Main.label.setText("Your Choise: Noodle");
						stage.close();
					}
				});
		
		Button btn2 = new Button();
		btn2.setText("Apple");
		btn2.setOnAction(new btnHandler("Apple"));
		
		Button btn3 = new Button();
		btn3.setText("Soup");
		btn3.setOnAction(new btnHandler("Soup"));
		
		Button btn4= new Button("Button 4");
		Button btn5= new Button("Button 5");
		Button btn6= new Button("Button 6");
		Button btn7= new Button("Button 7");
		
		//StackPane layout=new StackPane();
		VBox vb=new VBox();
		HBox hb=new HBox();
		BorderPane bp=new BorderPane();
		
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(label,cBox,btn1,btn2,btn3);

		
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(btn4,btn5,btn6,btn7);
		
		bp.setLeft(vb);
		bp.setTop(hb);
		
		
		Scene content=new Scene(bp,400,400);
		stage.setScene(content);
		stage.show();
	}
}
class btnHandler implements EventHandler<ActionEvent>
{
	String msg;
	public btnHandler(String message)
	{
		msg=message;
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Main.label.setText("Your Choise: "+msg);
		ChoiseWindow.stage.close();
	}
	
}