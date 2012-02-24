/**
 * @project TCP Client
 * @file TCPClient.java
 * @author Jonathan Katon
 * @date Feb 23, 2012
 * 
 */

import java.io.*;
import java.net.*;

public class TCPClient 
{

	public static void main(String[] args) throws Exception
	{
		String mySentence;
		String receivedSentence;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost", 6789);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		while(true)
		{	
			System.out.print("Me: ");
			
			mySentence = inFromUser.readLine();
			
			outToServer.writeBytes(mySentence +'\n');
			
			receivedSentence = inFromServer.readLine();

			System.out.println("From Server: " + receivedSentence);

		}
		
	}

}

