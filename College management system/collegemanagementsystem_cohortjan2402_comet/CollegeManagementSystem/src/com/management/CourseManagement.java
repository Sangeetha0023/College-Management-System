package com.management;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;

public class CourseManagement
{
	public boolean addCourseDetails(List<Course> cou)
	{
		try
		{
			int sta=0;
			for(Course c:cou)
			{
				DBConnectionManagement d=new DBConnectionManagement();
				Connection c1=d.getConnection();
			
				String q="insert into course values(?,?,?,?,?)";
				PreparedStatement p=c1.prepareStatement(q);
			
				p.setString(1,c.getCourseId());
				p.setString(2, c.getCourseName());
				p.setString(3, c.getCourseCoordinator());
				p.setString(4,c.getDepartment());
				p.setDouble(5, c.getCourseFee());
				
			
				sta=p.executeUpdate();
			}
			
			if(sta>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return false;

	}
	
	
	public boolean updateFee(Double f,String id)
	{
		int s=0;
		try
		{
			DBConnectionManagement d=new DBConnectionManagement();
			Connection c=d.getConnection();
			String q="update course set COURSE_FEE=? where COURSE_ID=?";
			PreparedStatement p=c.prepareStatement(q);
			p.setDouble(1,f);
			p.setString(2,id);
			
			s=p.executeUpdate();
			
			if(s>0)
			{
				return true;
			}
			
			return false;
			
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean deleteCourse(String id)
	{
		int s=0;
		try
		{
			DBConnectionManagement d=new DBConnectionManagement();
			Connection c=d.getConnection();
			String q="delete from course where COURSE_ID=?";
			PreparedStatement p=c.prepareStatement(q);
			p.setString(1, id);
			
			s=p.executeUpdate();
					
			if(s>0)
			{
				return true;
			}
			
			return false;
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public String viewFee(String id)
	{
		String s="";
		try
		{
			DBConnectionManagement d=new DBConnectionManagement();
			Connection c=d.getConnection();
			String q="select COURSE_FEE from course where COURSE_ID=?";
			PreparedStatement p=c.prepareStatement(q);
			p.setString(1, id);
			ResultSet r=p.executeQuery();
			
			while(r.next()) 
			{
				s=r.getString(1);
			}
			
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return s; 
	}
	
	public List<Course> retrieveCourseData(String id)
	{
		List<Course> clist=new ArrayList<Course>();
		try
		{
			DBConnectionManagement d=new DBConnectionManagement();
			Connection c=d.getConnection();
			String q="select * from course where COURSE_ID=?";
			PreparedStatement p=c.prepareStatement(q);
			p.setString(1, id);
			ResultSet r=p.executeQuery();
			
			while(r.next()) 
			{
				String cid=r.getString(1);
				String cname=r.getString(2);
				String coor=r.getString(3);
				String dept=r.getString(4);
				double cfee=r.getDouble(5);
				
				Course c1=new Course(id,cname,coor,dept,cfee);
				
				clist.add(c1);
			}
			
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return clist;
	}
}
	

