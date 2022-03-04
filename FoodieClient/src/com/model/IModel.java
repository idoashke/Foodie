package com.model;

public interface IModel {
	void transferData(String data);
	String toJson(String data);
	String fromJson(String data);
}
