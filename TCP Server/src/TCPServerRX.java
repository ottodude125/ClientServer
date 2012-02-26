/**
 * @project TCP Server
 * @file TCPServerRX.java
 * @author Jonathan Katon
 * @date Feb 25, 2012
 * 
 */

import java.io.*;
import java.net.*;

public class TCPServerRX extends Thread 
{
	String recievedSentence = "";
	Socket serverSocket;
	BufferedReader inFromClient;
	
	TCPServerRX(String name, Socket ssocket)
	{
		super(name);
		serverSocket = ssocket;
		start();
	}
	
	public void run()
	{		
		try
		{
			inFromClient = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
			
			while(recievedSentence != null)
			{
				try{
					recievedSentence = inFromClient.readLine();
					
					System.out.println("Client: " + recievedSentence);
					
					Thread.sleep(100);
				}
				catch (Exception e)
				{
					System.out.println("Error in server reciept: " + e);
				}
			}
			System.out.println("Thank You. Have a nice Day!!");	
		}
		catch (Exception e)
		{
			System.out.println("Error in server reader: " + e);
		}		
	}
}

