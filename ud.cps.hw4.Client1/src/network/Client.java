package network;


import java.io.IOException;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import sample.Msg;
import sample.MsgService;

public class Client {
	private Socket connection;
	private ObjectOutputStream output;
	public Listener listener;
	private String server_ip;
	private int port; 

	public Client(String ip,int _port,MsgService ms)
	{
		server_ip=ip;
		port=_port;
		listener =new Listener(ms);
		listener.bindClient(this);
		start();
	}

	public void start()
	{	

		setupSocket();
		setupStream();
		startListener();

	}
	private void startListener()
	{
		Thread t=new Thread(listener);
		t.start();
	}
	private void setupSocket()
	{

		System.out.println("setting up a connection");
		do{
			try {
				connection=new Socket(InetAddress.getByName(server_ip),port);
				System.out.println("connection established.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}while(connection==null);
	}
	private void setupStream()
	{
		try {
			output=new ObjectOutputStream(connection.getOutputStream());
			listener.bindSocket(connection);
			System.out.println("Streams were setup.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void sendMessage(Msg message)
	{
		try {
			output.writeObject(message);
			System.out.println("Message sent:"+message.getMsgContent().getText());
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



