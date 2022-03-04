package com.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;

public class JsonWriter {
	
	public static <OBJ> void Init(ArrayList<OBJ> objectsList, String path, Type type) throws IOException{
		Gson gson = new Gson();
		String jsonToSave = gson.toJson(objectsList, type);
//		System.out.println("json to save: " +jsonToSave);
		FileWriter fileWriter = new FileWriter(path, false);
		try {
			fileWriter.write(jsonToSave);
			System.out.println("Saved successfully.");
		} catch (Exception e) {
			System.out.println("Save failed");
		}		
		fileWriter.close();

//		String cust = gson.toJson(new Customer(12345, 200.50, "Avi", new Status("Platinum")));
//		FileWriter fileWriter = new FileWriter("Customer.json");
//		fileWriter.write(cust);
//		fileWriter.close();
	}
	
	
	public static String EntityToJson(String filePath) 
    {
        String content = "";
 
        try
        {
            content = new String (Files.readAllBytes(Paths.get(filePath)));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return content;
    }

}
