import java.io.*;
import java.net.*;

public class DClient
{
	// Some properties
	private String _server;
	private int _port = -1;
	private Socket _client = null;
	private PrintWriter _outStream = null;
	private BufferedReader _inStream = null;
	
	// Constructor with port
	public DClient(int port)
	{
		_server = "127.0.0.1";
		_port = port;
	}
	
	// Constructor with server and port
	public DClient(String server, int port)
	{
		_server = server;
		_port = port;
	}
	
	// Sends the message
	public String sendMessage(String message) throws IOException
	{
		// Setup a client
		_client = new Socket(_server, _port);
		
		// Set the outstream
		_outStream = new PrintWriter(_client.getOutputStream(), true);
		
		// Set the instrem
		_inStream = new BufferedReader(
						new InputStreamReader(_client.getInputStream())
					);
		
		// Send the message
		_outStream.println(message);
		
		// Read the response
		String response = _inStream.readLine();
		
		// Close up
		_outStream.close();
		_inStream.close();
		_client.close();
		
		// Return the response to the caller
		return response;
	}
}