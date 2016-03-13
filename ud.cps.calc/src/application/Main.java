package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main extends Application {
	Button[][] btn;
	static String opString=new String();
	static TextField Tfield;
	ArrayList operator =new ArrayList();
	ArrayList operand= new ArrayList();
	String btn_Text[][]={{"7","8","9","c"},
						{"4","5","6","+"},
						{"1","2","3","-"},
						{"0","*","/","="}};
	@Override
	public void start(Stage primaryStage) {
		try {
			
			TilePane tp= new TilePane();
			tp.setPrefColumns(4);
			tp.setHgap(7);
			tp.setVgap(7);
			tp.setAlignment(Pos.BASELINE_CENTER);
			
			VBox vb = new VBox();
			vb.setPrefSize(240, 400);
			
			VBox vb2 = new VBox();
			
			vb2.setAlignment(Pos.CENTER);
			vb2.setMaxSize(200, 50);
			Tfield=new TextField();
			//Tfield.setPrefSize(200, 50);
			Tfield.setMaxSize(200, 50);
			Tfield.setAlignment(Pos.CENTER);

			vb2.getChildren().add(Tfield);
			vb.getChildren().add(vb2);
			btn=new Button[4][4];
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++)
				{
					Button b=new Button();
					btn[i][j]=b;
					b.setText(btn_Text[i][j]);
					b.setPrefSize(50, 50);
					b.setOnAction(new btnHandler(btn_Text[i][j]));
					tp.getChildren().add(b);
				}
			
			vb.getChildren().add(tp);
			
			
			Scene scene = new Scene(vb,235,280);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	class btnHandler implements EventHandler<ActionEvent>
	{
		String op;
		public btnHandler(String key)
		{
			op=key;
			//System.out.println(op);
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			//System.out.println(op);
			Main.opString+=op;
			switch (op)
			{
			case "0":
				
			case "1":
				
			case "2":
				
			case "3":
				
			case "4":
				
			case "5":
				
			case "6":
				
			case "7":
				
			case "8":
				
			case "9":
				operand.add(op);
				break;
			case "+":
				
			case "-":
				
			case "*":
				
			case "/":
				operator.add(op);
				operand.add(";");
				break;
			case "=":
				
			case "c":
				operator.clear();
				operand.clear();
				Main.opString="";
			}
			Main.Tfield.setText(Main.opString);
			
			
		}
		
	}
}
