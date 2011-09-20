import java.io.*;

public class ServerLab
{
	public static void main(String[] args)
	{
		DServer serverSocket = new DServer(1234) 
		{
			public String processMessage(String message)
			{
				System.out.println(message);
				return message.toUpperCase();
			}
		};
		System.out.println("Server is running");
		serverSocket.start();
	}
}