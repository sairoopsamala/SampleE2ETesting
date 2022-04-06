package com.nk.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reading {

	private final static String  url = "jdbc:postgresql://localhost:5432/uni_students";
	private final static String user = "postgres";
	private final static String password = "Password@12345";
	/*
	 1)CREATE CONNECTION
	 2)CREATE STATEMENT
	 3)EXECUTE STATEMENT
	 4)CLOSE CONNECTION
	 */
	
	
	public static void main(String[] args) throws SQLException, IOException {
		
		//STEP1
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//STEP2
				Statement stmt = connection.createStatement();
				
				//step3: execute sql statement
				
				String s = "create table locations (LOCATION_ID decimal(4,0), STREET_ADDRESS varchar(40), POSTAL_CODE varchar(12),CITY varchar(30), COUNTRY_ID varchar(2))";
				stmt.execute(s);
				
				//Excel
				File src = new File("C:\\Users\\lenovo\\Desktop\\Book1.xlsx");
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheet("Sheet1");
				
				int rows = sheet.getLastRowNum();
				
				for(int r=1;r<=rows;r++)
				{
					XSSFRow row = sheet.getRow(r);
					double locId=row.getCell(0).getNumericCellValue();
					String streatAdd=row.getCell(1).getStringCellValue();
					double postalCode=row.getCell(2).getNumericCellValue();
					String city=row.getCell(3).getStringCellValue();
					String countryId=row.getCell(4).getStringCellValue();
					
					 s = "insert into locations values('"+locId+"', '"+streatAdd+"', '"+postalCode+"', '"+city+"', '"+countryId+"')";
					stmt.execute(s);
					stmt.execute("commit");


				}
				
				workbook.close();
				fis.close();
				
				System.out.println("Done!!");
	}


	
	}

