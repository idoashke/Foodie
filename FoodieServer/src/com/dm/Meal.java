package com.dm;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements FoodieObject, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	ArrayList<Food> foods;
	Double calories;
	Double protein;
	Double carbs;
	Double fat;
	Double sugars;

	public Meal(String name) {
		super();
		this.name = name;
		this.foods = new ArrayList<Food>();
		this.calories = 0.0;
		this.protein = 0.0;
		this.carbs = 0.0;
		this.fat = 0.0;
		this.sugars = 0.0;
	}

	public Meal() {
		// super();
		this.name = "Meal";
		this.foods = new ArrayList<Food>();
		this.calories = 0.0;
		this.protein = 0.0;
		this.carbs = 0.0;
		this.fat = 0.0;
		this.sugars = 0.0;
	}

	public Meal(Meal other) {
		this.name = other.name;
		this.foods = other.foods;
		this.calories = other.calories;
		this.protein = other.protein;
		this.carbs = other.carbs;
		this.fat = other.fat;
		this.sugars = other.sugars;
	}

	public String toString() {
//		return "Meal name: " + this.getName() + ", Foods: " + this.getFoods() + ", Calories: " + this.getCalories()
//				+ ", Protein: " + this.getProtein() + ", Carbohydrate: " + this.getCarbs() + ", Fat: " + this.getFat()
//				+ ", Sugars: " + this.getSugars();
		return "Meal's name: " + this.getName() + "\nMeal's values: "+ ", Calories: " + this.getCalories()
		+ ", Protein: " + this.getProtein() + ", Carbohydrate: " + this.getCarbs() + ", Fat: " + this.getFat()
		+ ", Sugars: " + this.getSugars() + "\nMeal's foods: " + this.printFoods(); 
	}

	public void addFood(Food food) { // when a button pressed
		try {
		this.foods.add(new Food(food));
		this.calories += food.getCalories();
		this.protein += food.getProtein();
		this.carbs += food.getCarbs();
		this.fat += food.getFat();
		this.sugars += food.getSugars();
		} catch (Exception e) {
			System.out.println("Food not found");
		}
	}

	public void removeFood(Food food) { // when a button pressed
		this.foods.remove(food);
		this.calories -= food.getCalories();
		this.protein -= food.getProtein();
		this.carbs -= food.getCarbs();
		this.fat -= food.getFat();
		this.sugars -= food.getSugars();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public Double getCalories() {
		return calories;
	}

	public Double getProtein() {
		return protein;
	}

	public Double getCarbs() {
		return carbs;
	}

	public Double getFat() {
		return fat;
	}

	public Double getSugars() {
		return sugars;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}
	
	public String printFoods(){
		String str= "";
		for (Food food : this.getFoods()) {
			str += ("Food No." + this.getFoods().indexOf(food) + ": " + food + "\n");
		}
		return str;
	}
//	

}
