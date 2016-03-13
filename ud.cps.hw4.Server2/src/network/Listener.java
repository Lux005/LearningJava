package network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.application.Platform;
import sample.Msg;
import sample.MsgService;

public class Listener implements Runnable
{
	ObjectInputStream input;
	Socket connection;
	Server server;
	MsgService msgService;
	public Listener (MsgService ms)
	{
		msgService=ms;
	}
	public void bindServer(Server _server)
	{
		server=_server;
	}
	public void bindSocket(Socket socket)
	{

		try {
			input=new ObjectInputStream(socket.getInputStream());
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
		} 
		catch(EOFException ex)
		{
			System.out.println("lost connection.");
			System.out.println("Restart the server.");
			if(server!=null)
				server.start();

		}
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Connection Terminated");

	}
}