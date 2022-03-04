package com.model;

import java.io.IOException;
import java.util.Observable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.server.Response;

public class MyModel extends Observable implements IModel {
	
	Client client = new Client();
	Gson gson = new Gson();

	
	public void transferData(String data){
		setChanged();
		try {
			String dataToTransfer = this.toJson(data);
			notifyObservers(fromJson(client.sendData(dataToTransfer)));
//			notifyObservers(client.sendData(data));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String toJson(String data) {
//		System.out.println(data);
		String[] parts = data.split("\\$", 2);
		String header = parts[0];
		String body = parts[1];
//		System.out.println("Header : " + header);
//		System.out.println("Body : " + body);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("header", header);
		jsonObject.addProperty("data", body);
		String message = gson.toJson(jsonObject);
		System.out.println("message in MyModel :  " + message);
		return message;
	}
	
	public String fromJson(String data) {
		Response response = gson.fromJson(data, Response.class);		
		String objType = response.getObjectType();
		String objData = response.getData();
		return (objType + "$" + objData);
	}

}
