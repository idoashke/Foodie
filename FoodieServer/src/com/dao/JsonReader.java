package com.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

public class JsonReader {
	
	public static <OBJ> ArrayList<OBJ> Init(String path, Type type)
	{
	String content = FileToString(path);
	ArrayList<OBJ> res = new ArrayList<OBJ>();
	Gson gson = new Gson();
	if (content.isEmpty()) { return res;}
	else { return gson.fromJson(content, type);}


		
////		String content = UtilityClass.ReadClass.FileToString(path);
////		String content = JsonReader.ReadClass.FileToString(path);
//		String content = FileToString(path);
////		System.out.println(type);
//		//System.out.println("content:  "+content);
////		System.out.println("check if content is empty : " +content.isEmpty());
//		Gson gson = new Gson();
//		return gson.fromJson(content, type);
	}
	
	
	public static String FileToString(String filePath) 
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
	
//	 public static class ReadClass
//	 {
//	  public static String TeamsJsonPath = Path.of(
//	    Paths.get(".").normalize().toAbsolutePath().toString(), 
//	    "_EXTRA",
//	    "Jsons","teams.json").toString();
//	  
//	  public static String MatchesJsonPath = Path.of(
//	    Paths.get(".").normalize().toAbsolutePath().toString(), 
//	    "_EXTRA",
//	    "Jsons","matches.json").toString();
//	  
//		public static String FileToString(String filePath) 
//	    {
//	        String content = "";
//	 
//	        try
//	        {
//	            content = new String (Files.readAllBytes(Paths.get(filePath)));
//	        } 
//	        catch (IOException e) 
//	        {
//	            e.printStackTrace();
//	        }
//	 
//	        return content;
//	    }
//	 }
	
}




//public static <OBJ> HashMap<String, OBJ> Init(String path, Type type)
//{
//	//TODO: Add a check if the file actually exists, if not, create it.
//	String contents = UtilityClass.ReadClass.FileToString(path);
//	Gson gson = new Gson();
//	return gson.fromJson(contents, type);
//}
//
// public static class ReadClass
// {
//  public static String TeamsJsonPath = Path.of(
//    Paths.get(".").normalize().toAbsolutePath().toString(), 
//    "_EXTRA",
//    "Jsons","teams.json").toString();
//  
//  public static String MatchesJsonPath = Path.of(
//    Paths.get(".").normalize().toAbsolutePath().toString(), 
//    "_EXTRA",
//    "Jsons","matches.json").toString();
// }
//
//public static String FileToString(String filePath) 
//{
//    String content = "";
//
//    try
//    {
//        content = new String (Files.readAllBytes(Paths.get(filePath)));
//    } 
//    catch (IOException e) 
//    {
//        e.printStackTrace();
//    }
//
//    return content;
//}

