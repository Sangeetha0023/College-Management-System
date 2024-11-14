package com.service;
import java.util.*;

import com.management.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Mark;
import com.util.ApplicationUtil;

public class MarkService {
	
	MarkManagement  mm = new MarkManagement();
	
	public boolean addMarkObject(String... markDetails)
	{
		List<Mark> lis = parseMarkDetails(markDetails);
		
		if(mm.addMark(lis))
		{
			return true;
		}
		return false;
		
	}
	
	public boolean updateCgpa(double cgpa,int sem)
	{
		if(mm.updateCgpa(cgpa,sem))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<Mark> viewMarkBySemester(int Semester)
	{
		return mm.viewMarkBySemester(Semester);
	}
	
	
	public ArrayList<Mark> viewMarkByStudentId(String studentId)
	{
		return mm.viewMarkByStudentId(studentId);
	}
	
	
	//Build mark list
	 public List<Mark> parseMarkDetails(String... markDetails)
	 {
		 List<Mark> markList = new ArrayList<Mark>();
		 
		 for(int i=0;i<markDetails.length;i++)
		 {
			 String m[] = markDetails[i].split(":");
		
			 String markId = m[0];
			 String studentId = m[1];
			 int semester = Integer.parseInt(m[2]);
			 String subject1 = m[3];
			 String subject2 = m[4];
			 String subject3 = m[5];
			 String subject4 = m[6];
			 String subject5 = m[7];
			 String subject6 = m[8];
			 String subject7 = m[9];
			 String subject8 = m[10];
			 int mark[]=new int[8];
			 for(int j=0;j<8;j++)
			 {
				 mark[j]=Integer.parseInt(m[j+3]);
				 
			 }
			 
			 ApplicationUtil au=new ApplicationUtil();
			 double gpa=au.calculateGpa(mark);
			 Mark mm = new Mark(markId,studentId,semester,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,gpa,gpa);
			 markList.add(mm);
		 }
			 return markList;
		 }
	 }

