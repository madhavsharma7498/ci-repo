package com.lti.dao.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

public class ConnManager {
	
	public static Connection connect() {
		try {
			Properties dbProps = new Properties();
			//dbProps.load(new FileReader("dev-db.properties"));
			dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));//We have to remove this hard-coded file name too
			//to remove the hard-coded file name - we need to pass the filename as a variable
			//one option is to pass vm arguement using -D option
			Class.forName(dbProps.getProperty("driverName"));
			return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("madhav"), dbProps.getProperty("madhav"));
		}
		catch(ClassNotFoundException | IOException | SQLException e){
			e.printStackTrace(); //not good, should be thrwon rather
			return null; //very bad , should throw some user defined exception
		}
	}
	
	
	/*public static Connection connect() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			return DriverManager.getConnection("jdbc:derby://localhost:1527/trainingdb", "madhav", "madhav");
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace(); //not good, should be thrwon rather
			return null; //very bad , should throw some user defined exception
		}
	}*/

}
