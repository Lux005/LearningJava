package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.MyDB;



public class SearchViewController implements Initializable {
	
	@FXML
	private BorderPane bPane;
	@FXML
	private TextField textfield;
	@FXML
	private TextFlow textflow;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	public void updateTextFlow(Msg m)//update each TextFlow in both windows.
	{
		textflow.getChildren().addAll(m.getMsgInfo(),m.getMsgContent());		
	}
	public void searchFuc(){
			textflow.getChildren().clear();
		
			String sql;
			sql = "SELECT id, user, message, time FROM records where message "
					+ "like '%"+textfield.getText()+"%'";
			ResultSet rs = MyDB.getRecords(sql);
			if (rs!=null)
			{
				try {
					while(rs.next()){
						updateTextFlow(MyDB.convertToMsg(rs));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}   

}
