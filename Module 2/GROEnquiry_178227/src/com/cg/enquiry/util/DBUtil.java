/************************************************************************************
 -> File                 : DBUtil.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Connects to oracle database
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.enquiry.exception.EnquiryDBException;

public class DBUtil {
	private static Connection conn;
	static FileInputStream fs = null;
	
	Logger logger = Logger.getRootLogger();
	public DBUtil() {
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	public static Connection getConnection() throws EnquiryDBException {
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
				throw new EnquiryDBException("Driver not found" +e.getMessage());
			} catch (SQLException e) {
				throw new EnquiryDBException("Problem in establishing connection "+e.getMessage());
			} catch (FileNotFoundException e) {
				throw new EnquiryDBException("Error in finding jdbc properties file"+e.getMessage());
			} catch (IOException e) {
				throw new EnquiryDBException("Error in fetching file data"+e.getMessage());
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
