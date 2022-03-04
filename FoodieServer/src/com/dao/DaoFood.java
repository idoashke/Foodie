package com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dm.Food;



public interface DaoFood {
	ArrayList<Food> getAll();
	Map<Long, Food> getAllById();
	Map<String, Food> getAllByName();
	Map<Double, Food> getAllByCal();
	Map<Double, Food> getAllByPro();
	Map<Double, Food> getAllByCarbs();
	Map<Double, Food> getAllByFat();
	Map<Double, Food> getAllBySug();
	
}

//public interface DaoFood<ID extends Serializable, T, S> {
//
//	//T get(  id);
//	ArrayList<T> getAll();
//	Map<T, S> getAllById();
//	Map<T, S> getAllByName();
//	Map<T, S> getAllByCal();
//	Map<T, S> getAllByPro();
//	Map<T, S> getAllByCarbs();
//	Map<T, S> getAllByFat();
//	Map<T, S> getAllBySug();
//
//}
