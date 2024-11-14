package com.service;

import java.util.*;

import com.model.Course;

import com.management.*;

public class CourseService 
{
	CourseManagement cm=new CourseManagement();
	public boolean addCourse(String... courseDetails)
	{
		List<Course> cList=parseCourseDetails(courseDetails);
		if(cm.addCourseDetails(cList))
		{
			return true;
		}
		return false;
	}
	
	public String viewFee(String id)
	{
		return cm.viewFee(id);
	}
	
	public boolean updateFee(String id,double fee)
	{
		
		if(cm.updateFee(fee,id))
		{
			return true;
		}
		return false;
	}
	
	public boolean deleteCourse(String id)
	{
		if(cm.deleteCourse(id))
		{
			return true;
		}
		return false;
	}
	
	public List<Course> retrieveCourseData(String id)
	{
		return cm.retrieveCourseData(id);
	}
	
	public List<Course> parseCourseDetails(String... courseDetails)
	{
		List<Course> courseList=new ArrayList<Course>();
		
		for(int i=0;i<courseDetails.length;i++)
		{
			String a[]=courseDetails[i].split(":");
			String cid=a[0];
			String cname=a[1];
			String coorname=a[2];
			String dept=a[3];
			Double fee=Double.parseDouble(a[4]);
			
			Course cs=new Course(cid,cname,coorname,dept,fee);
			courseList.add(cs);
			
		}
		return courseList;
	}
}
