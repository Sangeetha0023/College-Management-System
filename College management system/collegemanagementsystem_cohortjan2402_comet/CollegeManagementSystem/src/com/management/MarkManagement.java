package com.management;
import java.util.*;
import com.model.Mark;
import java.sql.*;

public class MarkManagement {
	
//insert mark
public boolean addMark(List<Mark> mList) 
{
	try {
		int status=0;
		for(Mark markObj:mList)
		{
			
	   DBConnectionManagement db=new DBConnectionManagement();
	   Connection con=db.getConnection();
	   String query="insert into mark values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1,markObj.getMarksId());
		stmt.setString(2, markObj.getStudentId());
		stmt.setInt(3, markObj.getSemester());
		stmt.setString(4,markObj.getSubject1());
		stmt.setString(5,markObj.getSubject2());
		stmt.setString(6,markObj.getSubject3());
		stmt.setString(7,markObj.getSubject4());
		stmt.setString(8,markObj.getSubject5());
		stmt.setString(9,markObj.getSubject6());
		stmt.setString(10,markObj.getSubject7());
		stmt.setString(11,markObj.getSubject8());
		stmt.setDouble(12,markObj.getGpa());
		stmt.setDouble(13,markObj.getCgpa());
		
		 status =stmt.executeUpdate();
		}
		if(status>0) 
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

//update mark
public boolean updateCgpa(double cgpa,int semester) {
	try {
		DBConnectionManagement db=new DBConnectionManagement();
		Connection con=db.getConnection();
		String query="update mark set CGPA = ? where SEMESTER = ?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setDouble(1, cgpa);
		stmt.setInt(2,semester);
		int status=stmt.executeUpdate();
		if(status > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
}
//retrive mark in gpa cgpa
 public ArrayList<Mark> viewMarkBySemester(int Semester)
 {
	 try
	 {
		 Connection con=DBConnectionManagement.getConnection();
		 ArrayList<Mark> list = new ArrayList<Mark>();
		 String query = "Select * from mark where SEMESTER = ?";
		 PreparedStatement stmt = con.prepareStatement(query);
		 stmt.setInt(1,Semester);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next())
		 {
			 String markId = rs.getString(1);
			 String studentId = rs.getString(2);
			 int semester = rs.getInt(3);
			 String subject1 = rs.getString(4);
			 String subject2 = rs.getString(5);
			 String subject3 = rs.getString(6);
			 String subject4 = rs.getString(7);
			 String subject5 = rs.getString(8);
			 String subject6 = rs.getString(9);
			 String subject7 = rs.getString(10);
			 String subject8 = rs.getString(11);
			 double gpa = rs.getDouble(12);
			 double cgpa = rs.getDouble(13);
			 Mark mObj = new Mark(markId,studentId,semester,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,gpa,cgpa);
			 list.add(mObj);
		 }
		 return list;
	 }
	 catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
 }
 
 public ArrayList<Mark> viewMarkByStudentId(String studentId)
 {
	 try
	 {
		 Connection con=DBConnectionManagement.getConnection();
		 ArrayList<Mark> list = new ArrayList<Mark>();
		 String query = "Select * from mark where STUDENT_ID = ?";
		 PreparedStatement stmt = con.prepareStatement(query);
		 stmt.setString(1,studentId);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next())
		 {
			 String markId = rs.getString(1);
			 String studId= rs.getString(2);
			 int semester = rs.getInt(3);
			 String subject1 = rs.getString(4);
			 String subject2 = rs.getString(5);
			 String subject3 = rs.getString(6);
			 String subject4 = rs.getString(7);
			 String subject5 = rs.getString(8);
			 String subject6 = rs.getString(9);
			 String subject7 = rs.getString(10);
			 String subject8 = rs.getString(11);
			 double gpa = rs.getDouble(12);
			 double cgpa = rs.getDouble(13);
			 Mark mObj = new Mark(markId,studentId,semester,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,gpa,cgpa);
			 list.add(mObj);
		 }
		 return list;
	 }
	 catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
 }
}


