package com.cg.pms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.pms.exception.ProductDBException;
public class DBUtil {
	private static Connection conn;
	public static Connection getConnection() throws ProductDBException {
		if(conn==null){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@ndaoracle:1521:ORCL11g","Lab01trg40","lab01oracle");			
			} catch (ClassNotFoundException e) {
				throw new ProductDBException("Driver not found");
			} catch (SQLException e) {
				throw new ProductDBException("Problem in establishing connection "+e.getMessage());
			}	
		}
		return conn;
	}
}