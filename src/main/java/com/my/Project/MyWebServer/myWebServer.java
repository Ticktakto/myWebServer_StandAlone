package com.my.Project.MyWebServer;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import java.io.OutputStream;


public class myWebServer {

	private static final Logger Log = Logger.getLogger(myWebServer.class.getName());
	
	public static void main(String[] args) {	
		try(ServerSocket server = new ServerSocket(8800)){
			
			Socket client = server.accept();
			Log.info("Connected with client : " + client.getInetAddress());
			
			OutputStream output_data = client.getOutputStream();
			String SendData = "Hello World";
			output_data.write(SendData.getBytes());
			
			output_data.close();
			client.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
