package com.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.dm.Food;
import com.dm.Meal;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

//public class FoodFileDao implements DaoFood<Long, Food> {
public class FoodFileDao implements DaoFood {
	// String path = "foods.json";
	static String path = Path.of(Paths.get("").normalize().toAbsolutePath().toString(), "src", "foods.json").toString();
	// ObjectOutputStream objectOutputStream;
	// ObjectInputStream objectInputStream;
	static ArrayList<Food> db;
	
	
	public FoodFileDao() {
		db = new ArrayList<Food>(readFile());
	}

	public static ArrayList<Food> readFile() {
		System.out.println(path);
		ArrayList<Food> foods = new ArrayList<>(); 
		//Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Food>>() {}.getType(); // Change to whatever you need
		foods = JsonReader.Init(path, type);

		return foods;
	}

//	public Food get(Long id) {
//		Food food = null;
//		try {
//
//			Map<Long, Food> db = (Map<Long, Food>) objectInputStream.readObject();
//			food = db.get(id);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return food;
//		return null;
//	}

	public ArrayList<Food> getAll() {
		//ArrayList<Food> foods = new ArrayList<Food>(readFile());
		ArrayList<Food> foods = new ArrayList<Food>(db);
		//Collections.copy(foods, db); // copying the ArrayList db to the ArrayList foods
		//Collections.sort(foods); // need to create a sort func for foods
		return foods;

	}
	
	public Map<Long, Food> getAllById(){
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<Long, Food> foodsById = new TreeMap<>();

		for (Food food : foods) {
			foodsById.put(food.getId(), food);
		}

		return foodsById;
	}
	
//	public Food getById(Long id){
//		ArrayList<Food> foods = new ArrayList<>(readFile());
//		SortedMap<Long, Food> foodsById = new TreeMap<>();
//
//		for (Food food : foods) {
//			foodsById.put(food.getId(), food);
//		}
//
//		return foodsById;
//	}

	public Map<String, Food> getAllByName() {
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<String, Food> foodsByName = new TreeMap<>();

		for (Food food : foods) {
			foodsByName.put(food.getName(), food);
		}

		return foodsByName;
	}

	public Map<Double, Food> getAllByCal() {
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<Double, Food> foodsByCal = new TreeMap<>();

		for (Food food : foods) {
			foodsByCal.put(food.getCalories(), food);
		}

		return foodsByCal;
	}

	public Map<Double, Food> getAllByPro() {
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<Double, Food> foodsByPro = new TreeMap<>();

		for (Food food : foods) {
			foodsByPro.put(food.getProtein(), food);
		}

		return foodsByPro;
	}

	public Map<Double, Food> getAllByCarbs() {
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<Double, Food> foodsByCarbs = new TreeMap<>();

		for (Food food : foods) {
			foodsByCarbs.put(food.getCarbs(), food);
		}

		return foodsByCarbs;
	}

	public Map<Double, Food> getAllByFat() {
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<Double, Food> foodsByFat = new TreeMap<>();

		for (Food food : foods) {
			foodsByFat.put(food.getFat(), food);
		}

		return foodsByFat;
	}

	public Map<Double, Food> getAllBySug() {
//		ArrayList<Food> foods = new ArrayList<>(readFile());
		ArrayList<Food> foods = new ArrayList<>(db);
		SortedMap<Double, Food> foodsBySug = new TreeMap<>();

		for (Food food : foods) {
			foodsBySug.put(food.getSugars(), food);
		}

		return foodsBySug;
	}

}
