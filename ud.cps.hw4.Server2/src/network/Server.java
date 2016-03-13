package network;

import java.io.EOFException;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import sample.Msg;
import sample.MsgService;

public class Server {
	private ServerSocket server_socket;
	private Socket connection;
	private ObjectOutputStream output;
	private Listener listener;
	private int port=5000;
	public Server(int _port,MsgService ms)
	{
		port=_port;
		listener=new Listener(ms);
		listener.bindServer(this);
		try {
			server_socket=new ServerSocket(port,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start();
	}
	public void start()
	{
		waitRequest();
		setupStream();
		startListener();
	}
	private void startListener()
	{
		Thread t=new Thread(listener);
		t.start();
	}
	private void waitRequest() 
	{
		System.out.println("Wait for a new client.");
		try {
			connection=server_socket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got a new client");
	}

	public void sendMessage(Msg message)
	{
		try {
			output.writeObject(message);
			System.out.println("Message sent:"+message.getMsgContent().getText());
			output.flush();
		}
		catch(EOFException ex)
		{
			System.out.println("lost connection");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setupStream()
	{
		System.out.println("setting up stream;");
		try {
			output =new ObjectOutputStream(connection.getOutputStream());
			listener.bindSocket(connection);
			System.out.println("The stream are setup!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



