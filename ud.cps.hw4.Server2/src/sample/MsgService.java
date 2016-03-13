package sample;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.MyDB;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import network.*;

public class MsgService {
	private TextFlow textflow;//tf1 pointer to the first window's TextFlow
	//user id is different for each window.
	Server server;
	//////////////////////////////////////////////////
	final static int serverPort=5000;
	final private String userName="Jack";
	//////////////////////////////////////////////////
	MsgService(TextFlow tf)
	{
		textflow=tf;
		server=new Server(serverPort,this);
		loadHistory();
	}
	public void send(Text message)//store a new message into the history
	{
		Msg m=new Msg(userName,message.getText(),message.getStyle());
		server.sendMessage(m);
		MyDB.insertMsg(m);
		updateTextFlow(m);
	}
	public synchronized void updateTextFlow(Msg m)//update each TextFlow in both windows.
	{
		textflow.getChildren().addAll(m.getMsgInfo(),m.getMsgContent());		
	}
	private void loadHistory()
	{
		MyDB.getConnection();
		try {
			MyDB.createTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		String sql;
		sql = "SELECT id, user, message, time FROM records";
		ResultSet rs = MyDB.getRecords(sql);
		if (rs!=null)
		{
			try {
				while(rs.next()){
					updateTextFlow(MyDB.convertToMsg(rs));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
