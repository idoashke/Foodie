package com.dm;

import java.io.Serializable;

public class Food implements FoodieObject, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Double calories;
	private Double protein;
	private Double carbs;
	private Double fat;
	private Double sugars;

	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
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
	
	public Food(Food other) {
		this.id = other.id;
		this.name = other.name;
		this.calories = other.calories;
		this.protein = other.protein;
		this.carbs = other.carbs;
		this.fat = other.fat;
		this.sugars = other.sugars;
	}
	
	public String toString() {
		return "Food name: " + this.getName() +
				", Calories: " + this.getCalories() + 
				", Protein: " + this.getProtein() + 
				", Carbohydrate: " + this.getCarbs() + 
				", Fat: " + this.getFat() + 
				", Sugars: " + this.getSugars();
	}

}
