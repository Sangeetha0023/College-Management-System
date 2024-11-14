package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Enrollment;
import com.model.Payment;
import com.util.ApplicationUtil;

public class PaymentManagement 
{
	public int insertPaymentDetails(Payment obj) {
		int status=0;
		try {
			Connection con=DBConnectionManagement.getConnection();
			String query="insert into payment values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,obj.getPaymentId());
			ps.setString(2,obj.getEnrollmentId());
			ApplicationUtil au=new ApplicationUtil();
			java.sql.Date date=au.convertUtilTOSqlDate(obj.getPaymentDate());
			ps.setDate(3,date);
			ps.setString(4, obj.getPaymentMode());
			ps.setDouble(5, obj.getAmount());
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
	
	public List<Payment> viewEnrollmentDetailByPaymentId(String id)
	{
		List<Payment> li = new ArrayList<Payment>();
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			
			String query = "Select * from payment where PAYMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String pid = rs.getString(1);
				String eid = rs.getString(2);
				java.util.Date pdate = rs.getDate(3);
				String pmode=rs.getString(4);
				double a=rs.getDouble(5);
				
				Payment eObj = new Payment(pid,eid,pdate,pmode,a);
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
	public List<Enrollment> viewPaymentDetailByEnrollmentId(String id)
	{
		List<Enrollment> li = new ArrayList<Enrollment>();
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			
			String query = "Select * from enrollment where ENROLLMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String enrollmentId = rs.getString(1);
				String studentId = rs.getString(2);
				String courseId = rs.getString(3);
				String feeStatus=rs.getString(4);
				
				Enrollment p = new Enrollment(enrollmentId,studentId,courseId,feeStatus);
				li.add(p);
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
	public String findCourseId(String id) {
		String s="";
		try {
			Connection con=DBConnectionManagement.getConnection();
			String query="select COURSE_ID from enrollment where ENROLLMENT_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public double findCourseAmount(String id) {
		double amount=0;
		try {
			Connection con=DBConnectionManagement.getConnection();
			String query="select COURSE_FEE from course where COURSE_ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				amount=rs.getDouble(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}
	
}
         