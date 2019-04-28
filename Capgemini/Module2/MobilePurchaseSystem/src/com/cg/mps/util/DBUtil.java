package com.cg.mps.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mps.exception.MobileDBException;

public class DBUtil {
	private static Connection conn;
	static FileInputStream fs = null;
	public static Connection getConnection() throws MobileDBException {
		if(conn==null){
			try {
				fs = new FileInputStream("resources/jdbc.properties");
				Properties prop = new Properties();
				prop.load(fs);
				String driver = "jdbc.driver";
				String url="jdbc.url";
				String user ="jdbc.user";
				String pass ="jdbc.password";
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,pass);			
			} catch (ClassNotFoundException e) {
				throw new MobileDBException("Driver not found");
			} catch (SQLException e) {
				throw new MobileDBException("Problem in establishing connection "+e.getMessage());
			} catch (IOException e) {
				System.err.println("Error in fetching file data");
			} catch (FileNotFoundException e) {
				System.err.println("Error in finding jdbc properties file");
			}
		}
		return conn;
	}
}