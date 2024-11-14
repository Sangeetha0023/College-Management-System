package com.management;
import com.util.ApplicationUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.model.Student;

public class StudentManagement {
	public boolean addStudentDetails(List<Student> sList)
	{
		ApplicationUtil u = new ApplicationUtil();
		try
		{
			int sta=0;
			for(Student sObj:sList)
			{
			Connection con=DBConnectionManagement.getConnection();
			String query = "insert into student values(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement p =con.prepareStatement(query);	
			
			p.setString(1,sObj.getAdmissionNumber());
			p.setString (2,sObj.getStudentId());
			p.setString(3,sObj.getStudentName());
			p.setDate(4,u.convertUtilTOSqlDate(sObj.getDob()));
			p.setInt(5,sObj.getYearOfStudy());
			p.setInt(6,sObj.getYearOfJoining());
			p.setInt(7,sObj.getTenthGradeMark());
			p.setInt(8,sObj.getTwelfthGradeMark());
			p.setString(9,sObj.getFirstGraduate());
			p.setString(10,sObj.getEmailId());
			p.setLong(11,sObj.getPhoneNumber());
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
	
public boolean updateStudentDetails(String id,Long phno)
{
	try
	{
		Connection con=DBConnectionManagement.getConnection();
		String query = "update student set PHONE_NUMBER =? where STUDENT_ID=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, phno);
		ps.setString(2, id);
		int status = ps.executeUpdate();
		if(status > 0)
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
		return false;
	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e.getMessage());
		return false;
	}
	

}

public ArrayList<Student> viewStudentByYearOfStudy(int yearOfStudy)
{
	try
	{
		Connection con=DBConnectionManagement.getConnection();
		ArrayList<Student> li = new ArrayList<Student>();

		

		String query = "Select ADMISSION_NUMBER,STUDENT_ID,STUDENT_NAME,DOB,YEAR_OF_STUDY,YEAR_OF_JOINING,TENTH_GRADE_MARK,TWELFTH_GRADE_MARK,FIRST_GRADUATE,EMAIL_ID,PHONE_NUMBER from student where YEAR_OF_STUDY =?";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, yearOfStudy);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String admissionNumber = rs.getString(1);
			String studentId = rs.getString(2);
			String studentName = rs.getString(3);
			Date dob = rs.getDate(4);
			int year = rs.getInt(5);
			int yearOfJoining = rs.getInt(6);
			int tenthGradeMark = rs.getInt(7);
			int twelfthGradeMark = rs.getInt(8);
			String firstGraduate = rs.getString(9);
			String emailId = rs.getString(10);
			long phoneNumber = rs.getLong(11);
			Student sObj = new Student(admissionNumber,studentId,studentName,dob,year,yearOfJoining,tenthGradeMark,twelfthGradeMark,firstGraduate,emailId,phoneNumber);
			li.add(sObj);
		}
		return li;
	}
	catch(SQLException e) 
	{
		return null;
	}
	catch(ClassNotFoundException e)
	{
		return null;
	}
}

public ArrayList<Student> viewStudentById(String studentId)
{
	try
	{
		Connection con=DBConnectionManagement.getConnection();
		ArrayList<Student> li = new ArrayList<Student>();
		String query = "Select ADMISSION_NUMBER,STUDENT_ID,STUDENT_NAME,DOB,YEAR_OF_STUDY,YEAR_OF_JOINING,TENTH_GRADE_MARK,TWELFTH_GRADE_MARK,FIRST_GRADUATE,EMAIL_ID,PHONE_NUMBER from student where STUDENT_ID = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, studentId);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String admissionNumber = rs.getString(1);
			String sid = rs.getString(2);
			String studentName = rs.getString(3);
			Date dob = rs.getDate(4);
			int year = rs.getInt(5);
			int yearOfJoining = rs.getInt(6);
			int tenthGradeMark = rs.getInt(7);
			int twelfthGradeMark = rs.getInt(8);
			String firstGraduate = rs.getString(9);
			String emailId = rs.getString(10);
			long phoneNumber = rs.getLong(11);
			Student sObj = new Student(admissionNumber,sid,studentName,dob,year,yearOfJoining,tenthGradeMark,twelfthGradeMark,firstGraduate,emailId,phoneNumber);
			li.add(sObj);
		}
		return li;
	}
	catch(SQLException e) 
	{
		return null;
	}
	catch(ClassNotFoundException e)
	{
		return null;
	}
}

public boolean deleteStudentDetails(String studentId)
{
	try
	{
		Connection con=DBConnectionManagement.getConnection();
		ArrayList<Student> li = new ArrayList<Student>();
		String query ="delete from student where STUDENT_ID = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, studentId);
		int status = ps.executeUpdate();
		if(status > 0)
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
		return false;
	}
	catch(ClassNotFoundException e)
	{
		return false;
	}

}

}

 
