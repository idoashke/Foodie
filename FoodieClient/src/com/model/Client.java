package com.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.server.Response;

public class Client {
	
	public String sendData(String data) throws IOException, ClassNotFoundException {
		return sendRequest(data);
	}
	
	private static String sendRequest(String data) throws IOException, ClassNotFoundException {
		String messageFromServer = "";
		try {
			InetAddress local = InetAddress.getLocalHost();
			Socket myServer = new Socket(local.getHostAddress(), 12345);
			
			// Send message to server
			Gson gson = new Gson();
			PrintWriter output = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));

//			System.out.println("message from client: " + data);
			output.println(data);
			output.flush();
			
			
			// Get message from the server
			
			BufferedReader input = new BufferedReader(new InputStreamReader(myServer.getInputStream()));
			messageFromServer = input.readLine();
			input.close();
			output.close();
			myServer.close();			
			
			
		} catch (UnknownHostException e) {
			System.out.println("Can't recieve any message from server");
//			e.printStackTrace();
		}

		return messageFromServer;
	}

}
