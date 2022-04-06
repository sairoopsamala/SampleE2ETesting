package com.nk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConnection {

	private final static String  url = "jdbc:postgresql://localhost:5432/uni_students";
	private final static String user = "postgres";
	private final static String password = "Password@12345";
	/*
	 1)CREATE CONNECTION
	 2)CREATE STATEMENT
	 3)EXECUTE STATEMENT
	 4)CLOSE CONNECTION
	 */
	
	
	public static void main(String[] args) throws SQLException {
		
		//STEP1
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//STEP2
				Statement stmt = connection.createStatement();
				
				//step3: execute sql statement
				
				//String s = "insert into employee values(104, 'SAI', 'Tester')";
				
				//Update Query
				//String s = "update employee set eid = '105' where eid='104'";
				
				//delete query
				//String s = "delete employee where eid='103'";

				String s = "Select name,qualification from employee";
				ResultSet rs = stmt.executeQuery(s);
				
				while(rs.next())
				{
					String name = rs.getString("name");
					String qualification = rs.getString("qualification");
					
					System.out.println("name:" +name);
					System.out.println("qualification:" +qualification);

				}
				//STEP4
				connection.close();
				
				System.out.println("Program is exited");
			}
			
	}
	
	/*public static void main(String[] args)
	{
		BDConnection sqlConnect = new BDConnection();
		sqlConnect.connect();
	}*/

