package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import com.dm.FoodieObject;

public interface IController<T extends FoodieObject> {
	ArrayList<T> get(ArrayList<T> objArr);
	int remove(ArrayList<T> objArr);
	int save(ArrayList<T> objArr);
}
