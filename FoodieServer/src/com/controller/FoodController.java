package com.controller;

import java.util.ArrayList;

import com.dm.Food;
import com.dm.FoodieObject;
import com.dm.User;
import com.service.FoodService;

public class FoodController<T>{
	
	FoodService foodService;
		
	
	public FoodController() {
		super();
		this.foodService = new FoodService();
	}

	
	public ArrayList<Food> get(String key, T data) {
		switch(key) {
		//Food - get
		  case "all":
			  return foodService.getAllFoods();
//			  break;
		  case "id":
			  Food food = new Food(foodService.getFoodById((Long) data));
			  ArrayList<Food> foods = new ArrayList<Food>();
			  foods.add(food);
			  return foods;
//			  break;
		  case "name":
			  return foodService.getFoodByName((String) data);
//			  break;
		  case "calMax":
			  return foodService.getFoodByCal((Double) data, true);
//			  break;
		  case "calMin":
			  return foodService.getFoodByCal((Double) data, false);
//			  break;
		  case "proMax":
			  return foodService.getFoodByPro((Double) data, true);
//			  break;
		  case "proMin":
			  return foodService.getFoodByPro((Double) data, false);
//			  break;
		  case "carbsMax":
			  return foodService.getFoodByCarbs((Double) data, true);
//			  break;
		  case "carbsMin":
			  return foodService.getFoodByCarbs((Double) data, false);
//			  break;
		  case "fatMax":
			  return foodService.getFoodByFat((Double) data, true);
//			  break;
		  case "fatMin":
			  return foodService.getFoodByFat((Double) data, false);
//			  break;
		  case "sugMax":
			  return foodService.getFoodBySug((Double) data, true);
//			  break;
		  case "sugMin":
			  return foodService.getFoodBySug((Double) data, false);
//			  break;
		  default:
			  return null;
		}
	}
}
