package com.cg.mra.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mra.exception.MobileRechargeException;

public class DBUtil {
	private static Connection conn;
	static FileInputStream fs = null;

	public static Connection getConnection() throws MobileRechargeException {
		if(conn==null){
			try {
				fs = new FileInputStream("resources/jdbc.properties");
				Properties prop = new Properties();
				prop.load(fs);
				String driver = prop.getProperty("jdbc.driver");
				String url=prop.getProperty("jdbc.url");
				String user =prop.getProperty("jdbc.user");
				String pass =prop.getProperty("jdbc.password");
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,pass);
				System.out.println("connected\n");
			} catch (ClassNotFoundException e) {
				throw new MobileRechargeException("Driver not found" +e.getMessage());
			} catch (SQLException e) {
				throw new MobileRechargeException("Problem in establishing connection "+e.getMessage());
			} catch (FileNotFoundException e) {
				throw new MobileRechargeException("Error in finding jdbc properties file"+e.getMessage());
			} catch (IOException e) {
				throw new MobileRechargeException("Error in fetching file data"+e.getMessage());
			}finally{
				if(fs != null){
					try {
						fs.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());;
					}
				}
			}
		}
		return conn;
	}

}
