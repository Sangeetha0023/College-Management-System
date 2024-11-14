package com.management;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import java.util.*;

public class DBConnectionManagement 
{
	private static Connection c;
	private static Properties p=new Properties();
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		
		try
		{
			FileInputStream f=new FileInputStream("db.properties");
			p.load(f);
			
			Class.forName(p.getProperty("DB_DRIVER_CLASS"));
			
			c=DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USERNAME"),p.getProperty("DB_PASSWORD"));
			
			return c;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return c;
		
	}
}
