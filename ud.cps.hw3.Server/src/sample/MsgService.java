package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

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
	}
	public void send(Text message)//store a new message into the history
	{
		Msg m=new Msg(userName,message.getText(),message.getStyle());
		server.sendMessage(m);
		updateTextFlow(m);
	}
	public synchronized void updateTextFlow(Msg m)//update each TextFlow in both windows.
	{
		textflow.getChildren().addAll(m.getMsgInfo(),m.getMsgContent());		
	}
}
