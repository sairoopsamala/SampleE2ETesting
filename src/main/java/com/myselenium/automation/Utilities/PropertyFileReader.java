package com.myselenium.automation.Utilities;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {

	public static Properties readProperties() {
		Properties p = new Properties();
		try {				
			String filePath = System.getProperty("user.dir")+"/Configuration/Config.properties";
			FileReader file;
			file = new FileReader(filePath);
			p.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
}
