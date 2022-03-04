package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;

import com.controller.FoodController;
import com.controller.IController;
import com.controller.UserController;
import com.dm.Food;
import com.dm.FoodieObject;
import com.dm.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class HandleRequest implements Runnable {
	Socket socket;
	
	public HandleRequest(Socket soc) {
		this.socket = soc;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = input.readLine();
//			System.out.println(" message: --> " +message);
			Gson gson = new Gson();

			Request request = gson.fromJson(message, Request.class);
			String header = request.getHeader();
			
			
			UserController userController = new UserController();
			FoodController foodController = new FoodController();
			ArrayList<Food> foods;
			ArrayList<User> users;
			ArrayList<Long> usersIds;
			
			Type type;
			String responseData;
			String objType;

			
			switch(header) {
			//Food - get
			  case "getAllFoods":
				  foods = new ArrayList<Food>(foodController.get("all", null));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				  
			    break;
			  case "getFoodById":
				  Long foodId = gson.fromJson(request.getData(), Long.class);
				  foods = new ArrayList<Food>(foodController.get("id", foodId));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByName":
				  String name = gson.fromJson(request.getData(), String.class);
				  foods = new ArrayList<Food>(foodController.get("name", name));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByCalMax":
				  Double calMax = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("calMax", calMax));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByCalMin":
				  Double calMin = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("calMin", calMin));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByProMax":
				  Double proMax = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("proMax", proMax));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByProMin":
				  Double proMin = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("proMin", proMin));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByCarbsMax":
				  Double carbsMax = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("carbsMax", carbsMax));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByCarbsMin":
				  Double carbsMin = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("carbsMin", carbsMin));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByFatMax":
				  Double fatMax = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("fatMax", fatMax));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodByFatMin":
				  Double fatMin = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("fatMin", fatMin));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodBySugMax":
				  Double sugMax = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("sugMax", sugMax));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			  case "getFoodBySugMin":
				  Double sugMin = gson.fromJson(request.getData(), Double.class);
				  foods = new ArrayList<Food>(foodController.get("sugMin", sugMin));
				  type = new TypeToken<ArrayList<Food>>(){}.getType();
				  responseData = gson.toJson(foods, type);
				  objType = "ArrayList<Food>";
				    break;
			//User - get
			  case "getAllUsersId":
				  usersIds = new ArrayList<Long>(userController.getAll());
				  type = new TypeToken<ArrayList<Long>>(){}.getType();
				  responseData = gson.toJson(usersIds, type);
				  objType = "ArrayList<Long>";
				    break;
			  case "getUserById":
				  Long userId = gson.fromJson(request.getData(), Long.class);
				  System.out.println("id: " + userId + " ,  type:  " + userId.getClass());
				  User user = new User(userController.get(userId));
				  type = new TypeToken<User>(){}.getType();
				  responseData = gson.toJson(user, type);
				  objType = "User";
				    break;
			//User - delete
			  case "deleteUser":
				  type = new TypeToken<ArrayList<User>>(){}.getType();
				  User userToDelete = new User(gson.fromJson(request.getData(), type));
				  int isDeleted = userController.delete(userToDelete);
				  type = new TypeToken<Integer>(){}.getType();
				  responseData = gson.toJson(isDeleted, type);
				  objType = "Integer";
				    break;
			//User - save
			  case "saveChanges":
				  type = new TypeToken<User>(){}.getType();
				  User userToSave = new User(gson.fromJson(request.getData(), type));
				  System.out.println("user -->  " + userToSave);
				  int isSaved = userController.save(userToSave);
				  type = new TypeToken<Integer>(){}.getType();
				  responseData = gson.toJson(isSaved, type);
				  objType = "Integer";
				    break;
			  default:
				  type = null;
				  objType = null;
				  responseData = null;
			}
			
			
			// Response to client

			System.out.println("objtype: " + objType);
			Response response = new Response(objType, responseData);
			PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			output.println(gson.toJson(response, Response.class));
			output.flush();

				
			
			
			input.close();
			output.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
