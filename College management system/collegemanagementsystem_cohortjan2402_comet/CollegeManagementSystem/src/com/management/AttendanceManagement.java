
package com.management;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Attendance;
import com.model.Student;
import com.util.ApplicationUtil;

public class AttendanceManagement {
	public boolean addAttendance(List<Attendance> alist)
	{
		int st=0;
	  try
	  {
		 
			  for(Attendance aObj:alist)
				{
				Connection con=DBConnectionManagement.getConnection();
				String query = "insert into Attendance values(?,?,?,?,?,?,?,?);";
				PreparedStatement p =con.prepareStatement(query);	
				  
				p.setString(1, aObj.getAttendanceId());
				p.setString(2, aObj.getStudentId());
				p.setString(3, aObj.getEnrollmentId());
				p.setInt(4, aObj.getSemester());
				p.setInt(5,aObj.getTotalworkingdays());
				p.setInt(6, aObj.getPresentdays());
				p.setInt(7, aObj.getAbsentdays());
				p.setInt(8, aObj.getAttendancepercentage());
				st=p.executeUpdate();	
				}
				if(st>0)
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
	
	ApplicationUtil au=new ApplicationUtil();
	public List<Attendance> viewAttendanceList(String attendanceId)
	{
		List<Attendance> li = new ArrayList<Attendance>();
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			
			String query = "select * from Attendance where ATTENDANCE_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, attendanceId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String sid= rs.getString(2);
				String eid= rs.getString(3);
				int sem = rs.getInt(4);
				int twd = rs.getInt(5);
				int pd = rs.getInt(6);
				int ad= rs.getInt(7);
				int ap = rs.getInt(8);
				Attendance a = new Attendance(id,sid,eid,sem,twd,pd,ad,ap);
				li.add(a);
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
	
	
	public List<Attendance> viewAttendanceListByStudentId(String studentId)
	{
		List<Attendance> lis = new ArrayList<Attendance>();
		try
		{
			Connection con=DBConnectionManagement.getConnection();
			
			String query = "select * from Attendance where STUDENT_ID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, studentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString(1);
				String sid= rs.getString(2);
				String eid= rs.getString(3);
				int sem = rs.getInt(4);
				int twd = rs.getInt(5);
				int pd = rs.getInt(6);
				int ad= rs.getInt(7);
				int ap = rs.getInt(8);
				Attendance a = new Attendance(id,sid,eid,sem,twd,pd,ad,ap);
				lis.add(a);
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
		return lis;
	}

  
}
