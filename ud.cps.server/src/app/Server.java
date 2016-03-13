package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server_socket;
	private Socket connection;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	String output_message;
	String input_message;
	private static final int port=5000;

	public void start()
	{
		try
		{
			server_socket=new ServerSocket(port,100);
			while(true)
			{
				waitRequest();
				setupConnection();
				provideService();
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
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
	private void sendMessage(String message) throws IOException
	{
		output.writeObject(message);
		output.flush();
		System.out.println("Server: "+message+"\n");
	}
	private void provideService()
	{
		output_message="How can help you?";
		try{
			sendMessage(output_message);
			sendMessage("Finish");
			do{
				input_message=(String)input.readObject();
				System.out.println("Clinet: "+input_message+"\n");
			}while(!input_message.equals("Finish"));
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
	private void setupConnection() throws IOException
	{
		output =new ObjectOutputStream(connection.getOutputStream());
		input=new ObjectInputStream(connection.getInputStream());
		System.out.println("The stream are setup!");
	}

}
