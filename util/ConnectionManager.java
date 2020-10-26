package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/** 
 Basic singletone implementation of connection manager
 does not consider thread safety 
 */
public class ConnectionManager {

	 private static Connection con=null;
	 /**
	  reading db properties from config.properties files
	  */
	 private static String url=null;
	 private static String username=null;
	 private static String password=null;
	 private static String driver=null;
	 static {
		 Properties props=new Properties();
		 try {
			props.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 // we are passign default values will be used in case property is missing
		 url=props.getProperty("mysql.url", "jdbc:mysql://localhost/test");
		 username=props.getProperty("mysql.username","root");
		 password=props.getProperty("mysql.password","Passw0rd");
		 driver=props.getProperty("mysql.driver","com.mysql.jdbc.Driver");
	 }
	/** 
	  making constructor private to restrict object creation and impl Singleton 
	 */
	 private ConnectionManager(){
		 
	 }
	
	public static Connection getConnection(){
		if(con==null){
				try {
					Class.forName(driver);
					con=DriverManager.getConnection(url, username, password);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} // not required if we are using jdbc 4.0
		}
		return con;
	}
	
	public static void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
