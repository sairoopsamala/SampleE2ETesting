package com.myselenium.automation.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.myselenium.automation.Utilities.PropertyFileReader;

public class DBConnections {
	static Connection conn = null;
	static Statement stmt = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		try {
			Properties p = PropertyFileReader.readProperties();
			Class.forName("com.mysql.cj.jdbc.Driver");				
			conn = DriverManager.getConnection( ""+ p.getProperty("url") + ","+ p.getProperty("user")+","+p.getProperty("password")+"");
			System.out.println("Connection Established Successfully....");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static Statement getStatement() throws SQLException {
		try {
			stmt = conn.createStatement();
			System.out.println("Statement Created..");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return stmt;
	}
	
}
