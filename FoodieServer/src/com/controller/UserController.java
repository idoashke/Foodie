package com.controller;

import java.util.ArrayList;

import com.dm.FoodieObject;
import com.dm.User;
import com.service.UserService;

public class UserController<T> {
	
	UserService userService;
	

	public UserController() {
		super();
		this.userService = new UserService();
	}
	
	public ArrayList<Long> getAll(){
		return userService.getAllUsersId();
		
	}
	
	public User get(Long id) {
		return userService.getUserById(id);
	}
	
	public int delete(User user) {
		return userService.deleteUser(user);
		
	}
	
	public int save(User user) {
		return userService.saveChanges(user);
		
	}


}












//package com.controller;
//
//import java.util.ArrayList;
//
//import com.dm.FoodieObject;
//import com.dm.User;
//import com.service.UserService;
//
//public class UserController implements IController<FoodieObject> {
//	
//	UserService userService;
//	
//
//	public UserController() {
//		super();
//		this.userService = new UserService();
//	}
//	
//	public ArrayList<Long> getAll() {
//		return userService.getAllUsersId();
//	}
//
////	@Override
////	public User get(ArrayList<FoodieObject> objArr) {
////		User user = new User((User) objArr.get(0));
////		return userService.getUserById(user.getId());
////	}
//	
//	@Override
//	public ArrayList<FoodieObject> get(ArrayList<FoodieObject> objArr) {
//		ArrayList<FoodieObject> users = new ArrayList<FoodieObject>();
//		User user = new User((User) objArr.get(0));
//		users.add(userService.getUserById(user.getId()));
//		return users;
//	}
//
//	@Override
//	public int remove(ArrayList<FoodieObject> objArr) {
//		User user = new User((User) objArr.get(0));
//		return userService.deleteUser(user);
//	}
//
//	@Override
//	public int save(ArrayList<FoodieObject> objArr) {
//		User user = new User((User) objArr.get(0));
//		return userService.saveChanges(user);
//	}
//
//}
