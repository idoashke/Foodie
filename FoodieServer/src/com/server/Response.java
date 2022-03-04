package com.server;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;

public class Response {
	
	public String objectType;
	public String data;
	
	
	public Response(String objectType, String data) {
		super();
		this.objectType = objectType;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Response [objectType=" + objectType + ", data=" + data + "]";
	}

	public String getObjectType() {
		return objectType;
	}

	public String getData() {
		return data;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public void setData(String data) {
		this.data = data;
	}
	


	
}
