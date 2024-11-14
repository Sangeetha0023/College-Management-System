package com.service;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

import com.management.AttendanceManagement;
import com.model.Attendance;
import com.model.Student;
import com.util.ApplicationUtil;

public class AttendanceService 
{
	AttendanceManagement am=new AttendanceManagement();
	
	
	public boolean addAttendance(String... attendanceDetails)
	{
		List<Attendance> alist=parseAttendanceDetails(attendanceDetails);
		if(am.addAttendance(alist))

		{
			return true;
		}
		return false;
	}
	
	
	public List<Attendance> viewAttendanceByStudentId(String studentId)
	{
		return am.viewAttendanceListByStudentId(studentId);
	}
	
	public List<Attendance> viewAttendanceByAttendanceId(String attendanceId)
	{
		return am.viewAttendanceList(attendanceId);
	} 

	ApplicationUtil au=new ApplicationUtil();
	public List<Attendance> parseAttendanceDetails(String... attendanceDetails)
	{
		List<Attendance> attendanceList=new ArrayList<Attendance>();
		
		for(int i=0;i<attendanceDetails.length;i++)
		{
			String s[]=attendanceDetails[i].split(":");
			
			String aid=s[0];
			String sid=s[1];
			String eid=s[2];
			int sem=Integer.parseInt(s[3]);
			int wdays=Integer.parseInt(s[4]);
			int pdays=Integer.parseInt(s[5]);
			int abdays=Integer.parseInt(s[6]);
			int p=au.calculatePercentage(pdays, wdays);
			
			Attendance a=new Attendance(aid,sid,eid,sem,wdays,pdays,abdays,p);
			attendanceList.add(a);
		}
		return attendanceList;
    }

}
	

