package com.service;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import com.dao.FoodFileDao;
import com.dm.Food;

import algo.BinarySearchAlgo;
import algo.KMPAlgo;

//public class FoodService<S,T,K> {
public class FoodService implements IService{
	FoodFileDao foodFileDao = new FoodFileDao();
	algo.IAlgoNumSearch algoNum;
	algo.IAlgoStringSearch algoStr;

	
	public ArrayList<Food> getAllFoods() {
		// getAll() --> returns foods = ArrayList of <Food>() - all the foods in db
		return foodFileDao.getAll();
	}


	public Food getFoodById(Long id) {
		// getAllById() --> returns foodsById = Sorted TreeMap of <Long, Food> - <id,
		// Food>

		algoNum = new BinarySearchAlgo();
		ArrayList<Long> idArr = new ArrayList<Long>(foodFileDao.getAllById().keySet());
		// int size = (foodFileDao.getAllById().size())-1;
		int size = idArr.size() - 1;
		int index = algoNum.search(idArr, 0, size, id);
		Food foodById = new Food(foodFileDao.getAllById().get(idArr.get(index)));

		// IAlgoSearch<Food,Food,Long> algo = null;
		// Food foodById = new Food(algo.searchElement(foodFileDao.getAllById(), id));

		return foodById;
	}

	public ArrayList<Food> getFoodByName(String name) {
		// getFoodByName() --> returns foodsById = Sorted TreeMap of <String, Food> -
		// <name, Food>
//		IAlgoSearch<Food,Food,String> algo = null;

		algoStr = new KMPAlgo();
		ArrayList<Food> foodByName = new ArrayList<Food>();
		ArrayList<String> namesArr = new ArrayList<String>(foodFileDao.getAllByName().keySet());
		for (String foodName : namesArr) {
			// send to kmp (foodName, name)
			// int flag = StringSearchAlgo.isSubstring(name, foodName);
			int flag = algoStr.stringSearch(name, foodName);
			if (flag == 1) {
				foodByName.add(foodFileDao.getAllByName().get(foodName));
			}
		}
		return foodByName;
	}

	public ArrayList<Food> getFoodByCal(Double cal, Boolean minMax) {
		ArrayList<Food> foodsToReturn = new ArrayList<Food>();
		// getFoodByCal() --> returns foodByCal = Sorted TreeMap of <Double, Food> -
		// <cal, Food>
		SortedMap<Double, Food> foodByCal = new TreeMap<>(foodFileDao.getAllByCal());
		if (minMax == true) { // Max
			foodByCal = foodByCal.headMap(cal + 1);
		} else { // Min
			foodByCal = foodByCal.tailMap(cal - 1);
		}
		foodsToReturn.addAll(foodByCal.values());
		return foodsToReturn;

//		IAlgoSearch<ArrayList<Food>,Food,Double> algo = null;
//		ArrayList<Food> foodByCal = new ArrayList<Food>(algo.searchElement(foodFileDao.getAllByCal(), cal));
//		return foodByCal;
	}

	public ArrayList<Food> getFoodByPro(Double pro, Boolean minMax) {
		ArrayList<Food> foodsToReturn = new ArrayList<Food>();
		// getFoodByPro() --> returns foodByPro = Sorted TreeMap of <Double, Food> -
		// <pro, Food>
		SortedMap<Double, Food> foodByPro = new TreeMap<>(foodFileDao.getAllByPro());
		if (minMax == true) { // Max
			foodByPro = foodByPro.headMap(pro + 1);
		} else { // Min
			foodByPro = foodByPro.tailMap(pro - 1);
		}
		foodsToReturn.addAll(foodByPro.values());
		return foodsToReturn;
//		IAlgoSearch<ArrayList<Food>,Food,Double> algo = null;
//		ArrayList<Food> foodByPro = new ArrayList<Food>(algo.searchElement(foodFileDao.getAllByPro(), pro));
//		return foodByPro;
	}

	public ArrayList<Food> getFoodByCarbs(Double carbs, Boolean minMax) {
		ArrayList<Food> foodsToReturn = new ArrayList<Food>();
		// getFoodByCarbs() --> returns foodByCarbs = Sorted TreeMap of <Double, Food> -
		// <carbs, Food>
		SortedMap<Double, Food> foodByCarbs = new TreeMap<>(foodFileDao.getAllByCarbs());
		if (minMax == true) { // Max
			foodByCarbs = foodByCarbs.headMap(carbs + 1);
		} else { // Min
			foodByCarbs = foodByCarbs.tailMap(carbs - 1);
		}
		foodsToReturn.addAll(foodByCarbs.values());
		return foodsToReturn;
//		IAlgoSearch<ArrayList<Food>,Food,Double> algo = null;
//		ArrayList<Food> foodByCarbs = new ArrayList<Food>(algo.searchElement(foodFileDao.getAllByCarbs(), carbs));
//		return foodByCarbs;
	}

	public ArrayList<Food> getFoodByFat(Double fat, Boolean minMax) {
		ArrayList<Food> foodsToReturn = new ArrayList<Food>();
		// getFoodByFat() --> returns foodByFat = Sorted TreeMap of <Double, Food> -
		// <fat, Food>
		SortedMap<Double, Food> foodByFat = new TreeMap<>(foodFileDao.getAllByFat());
		if (minMax == true) { // Max
			foodByFat = foodByFat.headMap(fat + 1);
		} else { // Min
			foodByFat = foodByFat.tailMap(fat - 1);
		}
		foodsToReturn.addAll(foodByFat.values());
		return foodsToReturn;

//		IAlgoSearch<ArrayList<Food>,Food,Double> algo = null;
//		ArrayList<Food> foodByFat = new ArrayList<Food>(algo.searchElement(foodFileDao.getAllByFat(), fat));
//		return foodByFat;
	}

	public ArrayList<Food> getFoodBySug(Double sug, Boolean minMax) {
		ArrayList<Food> foodsToReturn = new ArrayList<Food>();
		// getAllBySug() --> returns foodBySug = Sorted TreeMap of <Double, Food> -
		// <sug, Food>
		SortedMap<Double, Food> foodBySug = new TreeMap<>(foodFileDao.getAllBySug());
		if (minMax == true) { // Max
			foodBySug = foodBySug.headMap(sug + 1);
		} else { // Min
			foodBySug = foodBySug.tailMap(sug - 1);
		}
		foodsToReturn.addAll(foodBySug.values());
		return foodsToReturn;

//		IAlgoSearch<ArrayList<Food>,Food,Double> algo = null;
//		ArrayList<Food> foodBySug = new ArrayList<Food>(algo.searchElement(foodFileDao.getAllBySug(), sug));
//		return foodBySug;
	}

}
