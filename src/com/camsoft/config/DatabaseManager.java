package com.camsoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author chhaichivon on May Jun 30, 2018
 */

public class DatabaseManager {

	public static Connection sInstance = null;
	private static String database = "soap_service_db";
	private static String username = "root";
	private static String password = "";
	   
	public static Connection getInstance() {
	    
	   try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    sInstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,username,password);
	   } catch (ClassNotFoundException enfc) {
	    System.out.println("ClassNotFoundException in getConnection, " + enfc.getMessage());
	   } catch (SQLException sqle) {
	    System.out.println("SQLException in getConnection, " + sqle.getMessage());
	   }
	   return sInstance;
	  }
	  
	  
	  public static void main(String[] agrs) {
		  
		  
		  if(DatabaseManager.getInstance() != null) {
			  System.out.println("Connection Pass");
		  }else {
			  System.out.println("Connection Fail");
		  }
	  }
}
