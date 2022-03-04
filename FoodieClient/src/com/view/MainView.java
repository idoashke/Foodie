package com.view;

import java.awt.BorderLayout;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dm.Food;
import com.dm.Meal;
import com.dm.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.server.Response;

public class MainView extends Observable implements IView {

	private JPanel contentPane;
	private WelcomeScreen welcomeScreen;
	private NewUserScreen newUserScreen;
	private OpenUserScreen openUserScreen;
	private NewMealScreen newMealScreen;
	private JFrame frame;
	protected User user;
	private Gson gson = new Gson();

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CreateMainView();
			}
		});
	}



	//// Main view create \\\\
	protected void CreateMainView() {
		frame = new JFrame("Foodie");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		welcomeScreen = new WelcomeScreen(this);
		frame.getContentPane().add(welcomeScreen);
        //Display the window.
        frame.pack();
        frame.setVisible(true);	
        
        }
	
	//// Switches between views \\\\
	
	public void openNewUserView() { // When pressing "New" button in WelcomeScreen
		frame.remove(welcomeScreen);
		newUserScreen = new NewUserScreen(this);
		frame.getContentPane().add(newUserScreen);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
		
	}
	
	public void openMainView() { // When pressing "Cancel" button in NewUserScreen
		frame.remove(newUserScreen);
		welcomeScreen = new WelcomeScreen(this);
		frame.getContentPane().add(welcomeScreen);
        //Display the window.
        frame.pack();
        frame.setVisible(true);		
	}
	
	public void openExistingUserView() { // When pressing "Open" button in WelcomeScreen
		frame.remove(welcomeScreen);
		openUserScreen = new OpenUserScreen(this);
		frame.getContentPane().add(openUserScreen);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
	
	public void openNewMealView() {
		frame.remove(openUserScreen);
		newMealScreen = new NewMealScreen(this);
		frame.getContentPane().add(newMealScreen);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
	public void returnToExistingUserView() { // When pressing "Cancel" button in NewMealScreen
		frame.remove(newMealScreen);
		newUserScreen = new NewUserScreen(this);
		frame.getContentPane().add(openUserScreen);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
		
	}

	
	
	
	
	//// functions \\\\
	
	@Override
	public void setRequest(String header, String data) {
		String message = header + "$"+ data;
		setChanged();
		notifyObservers(message);
	}
	
	

	public void addNewMeal(Meal meal) {
		this.user.addMeal(meal);
		Type type = new TypeToken<User>(){}.getType();
		String jsonToSave = gson.toJson(user, type);
		String header = "saveChanges";
		setRequest(header, jsonToSave);
	}
	
	public void deleteMeal(int mealIndex) {
		ArrayList<Meal> meals = new ArrayList<Meal>(this.user.getMeals());
		meals.remove(mealIndex);
		this.user.setMeals(meals);
		Type type = new TypeToken<User>(){}.getType();
		String jsonToSave = gson.toJson(user, type);
		String header = "saveChanges";
		setRequest(header, jsonToSave);
	}
	
	
	
	
	
	
//	@Override
//	public void saveNewUser(String data) {
//		String header = "saveChanges";
//		String message = header + "$" + data;
////		JsonObject jsonObject = new JsonObject();
////		jsonObject.addProperty("header", header);
////		jsonObject.addProperty("data", data);
////		Gson gson = new Gson();
////		String message = gson.toJson(jsonObject);
//		setChanged();
//		notifyObservers(message);
//		frame.remove(newUserScreen);
//		WelcomeScreen welcomeScreen = new WelcomeScreen(this);
//		frame.getContentPane().add(welcomeScreen);
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//		
//	}
	
//	@Override
//	public void saveUser(String user) {
//		String header = "saveChanges";		
//	}
//	
//
//	@Override
//	public void deleteUser(String user) {
//		String header = "saveChanges";		
//	}
//	
//	public void setReturnedUser(String userStr) {
//		
//	}
	
	public void setReturnedData(String data) {
		Type type;
		System.out.println("data in setReturnedData:  " + data); // works for new user
		String[] parts = data.split("\\$", 2);
		String objType = parts[0];
		String objData = parts[1];
		switch(objType) {
		  case "User":
			  System.out.println("It's a User");
			  type = new TypeToken<User>(){}.getType();
			  user = gson.fromJson(objData, type);
			  openUserScreen.setUser(user);
		    // code block
		    break;
		  case "ArrayList<User>":
			  System.out.println("It's a User array");
			  type = new TypeToken<ArrayList<User>>(){}.getType();
			  ArrayList<User> users = gson.fromJson(objData, type);

		    // code block
		    break;
		  case "Food":
			  System.out.println("It's a Food");
			  type = new TypeToken<Food>(){}.getType();
			  Food food = gson.fromJson(objData, type);
		    // code block
		    break;
		  case "ArrayList<Food>":
			  System.out.println("It's a Food array");
			  type = new TypeToken<ArrayList<Food>>(){}.getType();
			  ArrayList<Food> foods = gson.fromJson(objData, type);
			  newMealScreen.setFoods(foods);
		    // code block
		    break;
		  case "Integer":
			  System.out.println("It's a Integer");
			  type = new TypeToken<Integer>(){}.getType();
			  Integer status = gson.fromJson(objData, type);
		    // code block
		    break;
		  case "ArrayList<Integer>":
			  System.out.println("It's a Integer array");
			  type = new TypeToken<ArrayList<Integer>>(){}.getType();
			  ArrayList<Integer> ids = gson.fromJson(objData, type);
		    // code block
		    break;
		  default:
		    // code block
		}
	}








}
