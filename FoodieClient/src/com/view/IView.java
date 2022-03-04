package com.view;

import com.dm.Meal;

public interface IView {
	void start();
	void setRequest(String header, String data);
	void setReturnedData(String data);
	void addNewMeal(Meal meal);
	void deleteMeal(int mealIndex);
	
	
	
//	void setRequest(String header, String data);
//	void deleteUser(String user);
//	void saveUser(String user);
//	void saveNewUser(String user);
//	void setReturnedData(String data);
}
