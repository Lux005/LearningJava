package application;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
 
public class MainController {
    @FXML private Text actiontarget;
    @FXML private TextField usernameField;
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Hello:"+usernameField.getText()+" Sign in button pressed");
        
    }
    
}