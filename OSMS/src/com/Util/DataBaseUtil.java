package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.constants.constants;

public class DataBaseUtil {
	
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName(constants.DRIVER);
			con = DriverManager.getConnection(constants.URL,constants.USERNAME,constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("connected successfully");
		return con;
	}
	
	public static void  closeConnection(Connection con)
	{
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
