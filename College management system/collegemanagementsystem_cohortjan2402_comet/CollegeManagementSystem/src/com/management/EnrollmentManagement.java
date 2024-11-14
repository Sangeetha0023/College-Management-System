package com.management;

import java.sql.*;
import java.util.*;
import com.model.Enrollment;
//import com.util.ApplicationUtil;

public class EnrollmentManagement 
{
	public boolean addEnrollmentDetails(List<Enrollment> eList)
	{
//		ApplicationUtil u = new ApplicationUtil();
		try
		{
			int status=0;
			for(Enrollment eObj:eList)
			{
				Connection con=DBConnectionManagement.getConnection();
				String query = "insert into enrollment values(?,?,?,?)";
				PreparedStatement p =con.prepareStatement(query);
				p.setString(1,eObj.getEnrollmentId());
				p.setString(2,eObj.getStudentId());
				p.setString(3,eObj.getCourseId());
				p.setString(4,eObj.getFeeStatus());
				status=p.executeUpdate();
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
		catch(SQLException |ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean updateEnrollmentDetails(String id,String feeStatus)
	{
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			String query = "update enrollment set FEE_STATUS =? where ENROLLMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(2,id);
			ps.setString(1, feeStatus);
			int status = ps.executeUpdate();
			if(status > 0)
			{
				return true;
			}
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
			
		}return false;
	}
	
	public List<Enrollment> viewEnrollmentDetailByCourseId(String course_id)
	{
		List<Enrollment> li = new ArrayList<Enrollment>();
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			
			String query = "Select * from enrollment where COURSE_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,course_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String enrollmentId = rs.getString(1);
				String studentId = rs.getString(2);
				String courseId = rs.getString(3);
				String feeStatus=rs.getString(4);
				
				Enrollment eObj = new Enrollment(enrollmentId,studentId,courseId,feeStatus);
				li.add(eObj);
			}
			
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}return li;
	}
	
	public List<Enrollment> viewEnrollmentDetailsByFeeStatus(String feeStatus)
	{
		List<Enrollment> li = new ArrayList<Enrollment>();
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			
			String query = "Select * from enrollment where FEE_STATUS=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, feeStatus);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String enrollmentId = rs.getString(1);
				String studentId = rs.getString(2);
				String courseId = rs.getString(3);
				String fee_Status=rs.getString(4);
				Enrollment eObj = new Enrollment(enrollmentId,studentId,courseId,fee_Status);
				li.add(eObj);
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
		return li;
	}
	
	public boolean deleteEnrollmentDetails(String enrollmentId)
	{
		try
		{
			Connection con=DBConnectionManagement.getConnection();

			String query ="delete from enrollment where ENROLLMENT_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, enrollmentId);
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
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return false;

	}
	
	public int updateStatus(String id) {
		int status=0;
		try {
			Connection con=DBConnectionManagement.getConnection();
			String query="update enrollment set FEE_STATUS=? where ENROLLMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,"Paid");
			ps.setString(2,id);
			status=ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
