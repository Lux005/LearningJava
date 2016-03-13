package network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.application.Platform;
import sample.Msg;
import sample.MsgService;

public 
class Listener implements Runnable
{
	ObjectInputStream input;
	Client client;
	Socket connection;
	MsgService msgService;
	public Listener(MsgService ms) {
		// TODO Auto-generated constructor stub
		msgService=ms;
	}
	public void bindClient(Client c)
	{
		client=c;
	}

	public void bindSocket(Socket _connection)
	{
		connection=_connection;
		try {
			input=new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			do{
				final Msg message;
				System.out.println("listening");
				message=(Msg)input.readObject();
				System.out.println("Message received:"+message.getMsgContent().getText());
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						msgService.updateTextFlow(message);
					}
				});
			}while(true);
		}catch(EOFException ex)
		{
			System.out.println("Lost Connection");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Connection Terminated");
	}
}