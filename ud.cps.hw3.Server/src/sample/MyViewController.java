package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;



public class MyViewController implements Initializable {
	
	private MsgService msgService;//includes message storage and textflow update operation.
	@FXML
	private BorderPane bPane;
	@FXML
	private ImageView userIcon;
	@FXML
	private TextFlow textflow;
	@FXML
	private TextArea textarea;
	@FXML 
	private ComboBox<String> fontColor;
	@FXML
	private ComboBox<String> fontSize;
	@FXML
	private ComboBox<String> bgColor;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		msgService=new MsgService(textflow);

		bgColor.setValue("blue");//different color for different user window.
		//Image icon=new Image("user1.png");//different image for different user window
		//userIcon.setImage(icon);	
		fontColor.setValue("black");//set default fontColor
		//set default style
		textarea.setStyle("-fx-text-fill:"+fontColor.getValue()+
				";-fx-font-size:"+fontSize.getValue());
		//set background color
		bPane.setStyle("-fx-background-color:"+bgColor.getValue()); 

	}


	public void sendFuc(){
		
		//convert string to a Text object
		Text content=new Text(textarea.getText()+"\n");
		
		//set the Text with user defined style. 
		content.setStyle("-fx-fill:"+fontColor.getValue()+
				";-fx-font-size:"+fontSize.getValue());
		
		//push current message into msg_history.
		msgService.send(content);
		
		textarea.clear();
	}
	public void clearFuc(){
		textflow.getChildren().clear();
	}   
	public void changeFont(){
		//change the font style setting
		textarea.setStyle("-fx-text-fill:"+fontColor.getValue()+
				";-fx-font-size:"+fontSize.getValue());
	}


	public void changeBG(){
		//change the background style setting
		bPane.setStyle("-fx-background-color:"+bgColor.getValue());
	}
}
