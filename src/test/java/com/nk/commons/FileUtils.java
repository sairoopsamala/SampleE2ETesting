package com.nk.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	static String filePath = System.getProperty("user.dir")+"/Configuration/Config.properties";
	static FileInputStream file = null;
	static Properties prop = null;
	
	public static String getProperty(String propertyName) 
	{
		String value=null;
		
		try {
			file = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(file);
			value = prop.getProperty(propertyName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	public static String getData(String propertyName) 
	{
		String value=null;
		
		try {
			file = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(file);
			value = prop.getProperty(propertyName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
		
	}

	
	
	
}
