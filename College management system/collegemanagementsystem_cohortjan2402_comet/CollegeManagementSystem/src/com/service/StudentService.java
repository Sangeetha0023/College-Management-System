package com.service;
import com.exception.InvalidStudentException;
import com.management.StudentManagement;

import java.util.*;

import com.util.ApplicationUtil;
import com.model.Student;
public class StudentService {

	StudentManagement sm = new StudentManagement();
	ApplicationUtil au=new ApplicationUtil();
	
	public boolean addStudentObject(String... studentDetails) throws InvalidStudentException
	{
		List<Student> li = parseStudentDetails(studentDetails);
		
		if(sm.addStudentDetails(li))
		{
			return true;
		}
		 
		return false;
	}
	
	
	
	
	
	public boolean updatePhoneNumber(String id,long phoneno)
	{
		if(sm.updateStudentDetails(id,phoneno))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<Student> viewStudentByYearOfStudy(int yearOfStudy)
	{
		return sm.viewStudentByYearOfStudy(yearOfStudy);
	}
	
	public ArrayList<Student> viewStudentById(String studentId)
	{
		return sm.viewStudentById(studentId);
	}
	
	public boolean deleteStudentDetails(String studentId)
	{
		return sm.deleteStudentDetails(studentId);
	}
	 
	

	
	 public List<Student> parseStudentDetails(String... studentDetails) throws InvalidStudentException
		{
			 List<Student> studList = new ArrayList<Student>();

			for(int i=0;i<studentDetails.length;i++)
			{
			String a[] = studentDetails[i].split(":");
			
			String ano = a[0];
			String id=au.generateId();
			if(au.validateStudentId(id))
			{
				try
				{
					String name=a[1];
					String d=a[2];
					Date date=au.convertStringToDate(d);
					int study = Integer.parseInt(a[3]);
					int joining =Integer.parseInt(a[4]) ;
					int tenth= Integer.parseInt(a[5]);
					int twelfth = Integer.parseInt(a[6]);
					String grad = a[7];
					String mail=a[8];
					long pno = Long.parseLong(a[9]);
					Student s= new Student(ano,id,name,date,study,joining,tenth,twelfth,grad,mail,pno);
					studList.add(s);
				}
				catch(Exception e)
				{
					e.getMessage();
				}
				
			}
			
			}
			return studList;
		}
}
