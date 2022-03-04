package com.server;

import com.google.gson.JsonElement;

public class Request {
	String header;
	String data;
	
	public Request(String header, String data) {
		super();
		this.header = header;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "TempRequest [header=" + header + ", data=" + data + "]";
	}
	
	public String getHeader() {
		return header;
	}
	
	public String getData() {
		return data;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
}
