/**
 * @project TCP Client
 * @file TCPClientRX.java
 * @author Jonathan Katon
 * @date Feb 25, 2012
 * 
 */

import java.io.*;
import java.net.*;

public class TCPClientRX implements Runnable
{
	String recievedSentence = "";
	Thread tcp;	
	Socket clientSocket;
	BufferedReader inFromServer;
	
	TCPClientRX(String name, Socket csocket)
	{
		tcp = new Thread(this, name);
		clientSocket = csocket;
		tcp.start();
	}
	
	public void run()
	{
		try{
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			while( recievedSentence != null)
			{
				try
				{				
					recievedSentence = inFromServer.readLine();
					
					System.out.println("Server: " + recievedSentence);
					
					Thread.sleep(100);
		
				}
				catch (Exception e)
				{
					System.out.println("Error in client reciept: " + e);
				}
			}
			System.out.println("Thank You. Have a nice Day!!");	
		}
		catch (Exception e)
		{
			System.out.println("Error with client reader: " + e);
		}
	
	}
}
