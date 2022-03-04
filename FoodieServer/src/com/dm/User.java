package com.dm;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements FoodieObject, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String name;
	int age;
	Integer gender;
	int height;
	Double weight;
	Double bmr;
	ArrayList<Meal> meals;

	
	
	
//	public User() {
//		
//	}
	
	public User(Long id, String name, int age, Integer gender, int height, Double weight) {
		//super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.bmr = bmrCalc(age, gender, height, weight);
		this.meals = new ArrayList<Meal>();

	}
	
	
	public User(Long id, String name, int age, Integer gender, int height, Double weight, Double bmr,
			ArrayList<Meal> meals) {
		//super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.bmr = bmr;
		this.meals = new ArrayList<Meal>(meals);

	}
	
	public User(User other) {
		this.id = other.id;
		this.name = other.name;
		this.age = other.age;
		this.gender = other.gender;
		this.height = other.height;
		this.weight = other.weight;
		this.bmr = other.bmr;
		this.meals = new ArrayList<Meal>(other.meals);
	}
	
	public boolean equals(User other) {
    	System.out.println("this id: "+ this.id);
    	System.out.println("other id: " +other.id);

		if (this.id == other.id) {return true;}
		else {return false;}
	}
	

	public String toString() {
//		if (this == null) return null;
		int  gen = this.getGender();
		String genStr = null;
		if (gen == 1) { genStr = "Male";}
		else if (gen == 0) {genStr = "Female";}
		return "--- User Personal Info --- \n" + "User ID: " + this.getId() +
				", Name: " + this.getName() + 
				", Age: " + this.getAge() + 
				", Gender: " + genStr + 
				", Height: " + this.getHeight() + 
				", Weight: " + this.getWeight() +
				", Bmr: " + this.getBmr() +
				"\n--- Meals Details --- \n" + this.getMeals();
	}



	private Double bmrCalc(int age, Integer gender, int height, Double weight) {
		if (gender == 1) {
			return (88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age));
					}
		else if (gender == 0) {
			return (447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age));
		} else {
			return null;
		}

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getBmr() {
		return bmr;
	}
	public void setBmr(Double bmr) {
		this.bmr = bmr;
	}
	
	
	
	public void calcTotal() {   // when a button pressed
		Double calories = 0.0;
		Double protein = 0.0;
		Double carbs = 0.0;
		Double fat = 0.0;
		Double sugars = 0.0;
		for (Meal obj : this.meals) {
			calories += obj.getCalories();
			protein += obj.getProtein();
			carbs += obj.getCarbs();
			fat += obj.getFat();
			sugars += obj.getSugars();
			
		}
	}
	
	

	
	public ArrayList<Meal> getMeals() {
		return meals;
	}


	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	
	
	public void addMeal(Meal meal) {
		this.meals.add(meal);
		this.calcTotal();
	}


	public void removeMeal(Meal meal) {
		this.meals.remove(meal);
		this.calcTotal();
	}

}
