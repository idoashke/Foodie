package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.dm.Food;
import com.dm.Meal;
import com.dm.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class UserFileDao implements DaoUser<Long, User> {

	// static String path =
	// Path.of(Paths.get("").normalize().toAbsolutePath().toString(),"user.json").toString();
//	static String path = Path.of(Paths.get("").normalize().toAbsolutePath().toString(), "src").toString();
	static String path = Path.of(Paths.get("").normalize().toAbsolutePath().toString(), "src", "users.json").toString();

	public ArrayList<User> getAll() {
//		System.out.println(path);
		ArrayList<User> users = new ArrayList<>();
		// Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<User>>() {}.getType(); // Change to whatever you need
		users = JsonReader.Init(path, type);

		return users;
	}

	@Override
	public User get(Long id) {
		ArrayList<User> users = new ArrayList<>(this.getAll());
		HashMap<Long, User> usersById = new HashMap<Long, User>();
		for (User user : users) {
			usersById.put(user.getId(), user);
		}
		try {
			return usersById.get(id);
		} catch (Exception e) {
			System.out.println("User not found");
			return null;
			// e.printStackTrace();
		}
		//return null;

		/// User per file \\\
//		ArrayList<User> users = new ArrayList<>();
//		String fileName = id.toString();
//		String userPath = path + fileName + ".json";
//		Gson gson = new Gson();
//		Type type = new TypeToken<ArrayList<User>>() {
//		}.getType(); // Change to whatever you need
//		users = JsonReader.Init(userPath, type);
//		User user = users.get(0);
////        User user = gson.fromJson(userPath, User.class);        
//		// System.out.println(user);
//		return user;

	}

	@Override
	public int delete(User entity) throws IOException {
		ArrayList<User> users = new ArrayList<>(this.getAll());
		try {
			users.remove(entity);
			saveAll(users);
			return 1;
		} catch (Exception e) {
			System.out.println("Deletion failed");
		}
//		saveAll(users);
		return 0;
//		int res = this.saveAll(users);
//		if (res == 1) { System.out.println("Deleted successfully"); }
//		else {System.out.println("Deletion failed");}
		
		
		
		
//		Type type = new TypeToken<ArrayList<User>>() {}.getType(); // Change to whatever you need
//		int res = JsonWriter.Init(users, path, type);
		
		
		
		/// User per file \\\
//		String fileName = entity.getId().toString();
//		File file = new File(path + fileName + ".json");
//		file.delete();

	}
	
	public int find(ArrayList<User> users, long id) throws IOException {
		for (User user : users) {
			if (user.getId() == id) return users.indexOf(user);
		}
		return -1;
	}

	
	public int saveAll(ArrayList<User> users) throws IOException {
		Type type = new TypeToken<ArrayList<User>>() {}.getType(); // Change to whatever you need
		try {
			JsonWriter.Init(users, path, type);
			return 1;
		} catch (Exception e) {
			System.out.println("Couldn't save changes");
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public int save(User entity) throws IOException {
		ArrayList<User> users = new ArrayList<>(this.getAll());
		System.out.println("entity.getId(): " + entity.getId());
		int oldEntityIndex = find(users, entity.getId());
		if (oldEntityIndex != -1) users.remove(oldEntityIndex);
		users.add(entity);
//		for (User user : users) { System.out.println(user);}
		return saveAll(users);
	}
	
	
	public Map<Long, User> getAllById(){
		ArrayList<User> users = new ArrayList<User>(getAll());
		SortedMap<Long, User> usersById = new TreeMap<>();

		for (User user : users) {
			usersById.put(user.getId(), user);
		}

		return usersById;
	}

//	@Override
//	public void save(User entity) throws IOException {
//		// TODO Auto-generated method stub
//		
//		
//		
//		
//		String fileName = entity.getId().toString();
//		File file = new File(path + fileName + ".json");
//		FileWriter fileWriter = new FileWriter(file, false);
//		gson.toJson(entity, fileWriter);
//		fileWriter.close();
//
////		if (file.exists() && !file.isDirectory()) {
////			gson.toJson(entity, new FileWriter(file, false));
////
////		} else {
////			file.createNewFile();
////		}
////		gson.toJson(entity, new FileWriter(fileName));
//
//	}

}

//public class UserFileDao implements DaoUser<Long, User> {
//
//	String path = "users.txt";
//	ObjectOutputStream objectOutputStream;
//	ObjectInputStream objectInputStream;
//
//	public UserFileDao() throws FileNotFoundException, IOException {
//		objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
//		objectInputStream = new ObjectInputStream(new FileInputStream(path));
//	}
//
//	@Override
//	public User get(Long id) {
//		User user = null;
//		try {
//			Map<Long, User> db = (Map<Long, User>) objectInputStream.readObject();
//			user = db.get(id);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return user;
//	}
//
//	public List<User> getAll() {
//		List<User> users = null;
//		try {
//			Map<Long, User> db = (Map<Long, User>) objectInputStream.readObject();
//			users = (List<User>) db.values();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return users;
//	}
//
//	@Override
//	public void delete(User entity) {
//		try {
//			Map<Long, User> db = (Map<Long, User>) objectInputStream.readObject();
//			db.remove(entity.getId());
//			objectOutputStream.writeObject(db);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void save(User entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
