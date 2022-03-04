package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	private static boolean serverUp = true;

	public static void main(String[] args) {
		try {
			ServerSocket myServer = new ServerSocket(12345);
			while(serverUp) {
				System.out.println("Server is up");
				Socket client = myServer.accept();
				Thread thread = new Thread(new HandleRequest(client));
				thread.start();
			}
			myServer.close();
			
		} catch (IOException e) {
			System.out.println("Couldn't run server");
		}
	}

}
