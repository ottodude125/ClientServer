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
		String sentence;
		String modifiedSentence;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost", 6789);
		
		while(true)
		{
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			sentence = inFromUser.readLine();
			
			outToServer.writeBytes(sentence +'\n');
			
			modifiedSentence = inFromServer.readLine();
			
			System.out.println("From Server: " + modifiedSentence);
			
			//clientSocket.close();
			
			//inFromUser.close();
			
			//outToServer.close();
			
			//inFromUser.close();
		}
		
	}

}

