package com.service;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.UserFileDao;
import com.dm.Food;
import com.dm.User;

import algo.BinarySearchAlgo;

public class UserService implements IService {
	UserFileDao userFileDao = new UserFileDao();
	algo.IAlgoNumSearch algoNum;
	algo.IAlgoStringSearch algoStr;
	
	
	public User getUserById(Long id) {
		return userFileDao.get(id);		
	}
	
	public ArrayList<Long> getAllUsersId(){
		algoNum = new BinarySearchAlgo();
		ArrayList<Long> allUsersId = new ArrayList<Long>(userFileDao.getAllById().keySet());
		return allUsersId;
	}
	
	public int deleteUser(User user) {
		try {
			return userFileDao.delete(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int saveChanges(User user) {
		try {
			return userFileDao.save(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
