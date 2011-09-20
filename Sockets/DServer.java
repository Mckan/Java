import java.io.*;
import java.net.*;

public class DServer extends Thread
{
	// Some property fields
	private int _port = -1;
	private boolean _isRunning = false;
	private ServerSocket _server = null;
	private Socket _client = null;
	private PrintWriter _outStream = null;
	private BufferedReader _inStream = null;

	// Constructors
	public DServer() { }
	public DServer(int port) { _port = port; }
	
	// Get and Set port
	public int getPort() { return _port; }
	protected void setPort(int port) { _port = port; }
	
	// Get and Set isRunning
	public boolean isRunning() { return _isRunning; }
	protected void setIsRunning(boolean isRunning) { _isRunning = isRunning; }
	
	public String processMessage(String message)
	{
		return message;
	}
	
	// Run the thread
	final public void run()
	{
		_isRunning = true;
		
		// Try to create a server socket on the port
		try { _server = new ServerSocket(_port); }
		catch(IOException ex) { System.err.println(ex.getMessage()); return; }

		while(_isRunning)
		{
			// Wait for client to talk to us
			try { _client = _server.accept(); }
			catch(IOException ex) { System.err.println(ex.getMessage()); return; }
			
			try
			{
				_outStream = new PrintWriter(_client.getOutputStream(), true);
				_inStream = new BufferedReader(
								new InputStreamReader(_client.getInputStream())
							);
				_outStream.println(processMessage(_inStream.readLine()));
				
			}
			catch(IOException ex) { System.err.println(ex.getMessage()); return; }
		}
		
	}

	
}