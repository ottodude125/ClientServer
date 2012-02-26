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
		String mySentence;
		
		ServerSocket welcomeSocket = new ServerSocket(6789);

		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		
		new TCPServerRX("Recieve Message", connectionSocket);

		while(true)
		{				
			mySentence = inFromUser.readLine();

			outToClient.writeBytes(mySentence + '\n');
			
			Thread.sleep(100);			
		}
	}
}
