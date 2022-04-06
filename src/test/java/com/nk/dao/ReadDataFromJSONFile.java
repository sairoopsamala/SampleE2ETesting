package com.nk.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {
	
	private final static String  url = "jdbc:postgresql://localhost:5432/uni_students";
	private final static String user = "postgres";
	private final static String password = "Password@12345";

	public static void main(String[] args) throws  IOException, ParseException, SQLException {

		//STEP1
				Connection connection = DriverManager.getConnection(url, user, password);
				
				//STEP2
						Statement stmt = connection.createStatement();
						
						//step3: execute sql statement
						
//						String s = "create table Employees (firstName varchar(40), lastName varchar(20),address_1 varchar(30), address_2 varchar(20))";
//						stmt.execute(s);
		
	JSONParser jsonParser = new JSONParser();
	
	FileReader reader = new FileReader(".\\jsonfiles\\employee.json");
	
	
	  Object obj = jsonParser.parse(reader);
	  
	  JSONObject empjsonobj = (JSONObject)obj;
	 
	
	
	  String fname= (String) empjsonobj.get("firstName");
	  String lname=(String)	empjsonobj.get("lastName");
	  
	  System.out.println("First name:"+fname);
	  System.out.println("Last name:"+lname);
	  
	  JSONArray array = (JSONArray)empjsonobj.get("address");
	  
	  for(int i=0; i<array.size();i++) 
	  { 
		  
	   JSONObject address = (JSONObject) array.get(i);
	  
	  String street = (String) address.get("street"); 
	  String city = (String) address.get("city"); 
	  String state = (String) address.get("state");
	  
	  System.out.println("Address of "+i+" is ............");
	  System.out.println("Street:"+street); 
	  System.out.println("Street:"+city);
	  System.out.println("Street:"+state);
	  
	String  s = "insert into Employees (firstName, lastName, address_1) values('"+fname+"', '"+lname+"', '"+street+", "+city+", "+state+"')";
		stmt.execute(s);
		stmt.execute("commit");

	  }
		System.out.println("Done!!");

	}

}
