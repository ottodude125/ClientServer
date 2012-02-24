/**
 * @project TCP Server
 * @file TCPServer.java
 * @author Jonathan Katon
 * @date Feb 23, 2012
 * 
 */

import java.io.*;
import java.net.*;

public class TCPServer
{

	public static void main(String[] args) throws Exception
	{
		String receivedSentence;
		String mySentence;
		
		ServerSocket welcomeSocket = new ServerSocket(6789);

		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

		while(true){

			receivedSentence = inFromClient.readLine();
			
			System.out.println("From Client: " + receivedSentence);
			
			System.out.print("Me: ");
			
			mySentence = inFromUser.readLine();

			outToClient.writeBytes(mySentence + '\n');
			
		}
	}

}
