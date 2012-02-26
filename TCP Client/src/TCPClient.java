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
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost", 6789);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				
		new TCPClientRX("Recieve Message", clientSocket);	
		
		while(true)
		{	
			mySentence = inFromUser.readLine();
			
			outToServer.writeBytes(mySentence +'\n');
			
			Thread.sleep(100);
		}		
	}
}

