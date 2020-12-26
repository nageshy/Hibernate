package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		try{
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String userName = "nageshy";
			String password = "Value*12";
			
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
