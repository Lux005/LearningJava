package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private Socket socket;
	private String input_message;
	private String output_message;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	final static private String server_ip="131.238.186.183";
	final static private int port=5000; 
	public void start()
	{	
		try {
			sendRequest();
			setupStream();
			askForServices();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void sendRequest()
	{
		System.out.println("Sending out a request");
		try {
			socket=new Socket(InetAddress.getByName(server_ip),port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The request is sent out successfully");
	}
	private void setupStream()
	{
		try {
			System.out.println("Stream");
			output=new ObjectOutputStream(socket.getOutputStream());
			input=new ObjectInputStream(socket.getInputStream());
			System.out.println("end Stream");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Streams were setup.");
	}
	private void askForServices() throws ClassNotFoundException, IOException
	{
		do{
			System.out.println("listening");
			input_message=(String)input.readObject();
			System.out.println("Message received:"+input_message);
		}while(!input_message.equals("Finish"));
		output.writeObject("Hello");
		output.flush();
		System.out.println("Message sent: Hello");
		output.writeObject("Finish");
		output.flush();
		System.out.println("Message sent: Finish");
	}
}
