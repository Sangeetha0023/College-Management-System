package com.util;
import com.exception.*;
import com.model.Mark;

import java.text.*;
import java.util.regex.Pattern;
public class ApplicationUtil {
	static int num=0;
	static int n1=0;
	static int n2=0;
	 public static java.util.Date convertStringToDate(String date)
	 { 
		
	        String pattern = "dd-MM-yyyy";
	        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		 java.util.Date d=null;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		 return d;
	 }
	 public java.sql.Date convertUtilTOSqlDate(java.util.Date date)
	 { 
		 java.sql.Date d = new java.sql.Date(date.getTime());
		 return d;
	 }
	 
	public String generateId()
	{
		num++;
		String str="CRISP"+num;
		return str;
	}
	
	
	
	
	public boolean validateStudentId(String studentId) throws InvalidStudentException
	{
		if(Pattern.matches("CRISP[0123456789]+", studentId))
		{
			return true;
		}
		else
		{
			throw new InvalidStudentException("student with id "+studentId+" is not valid");
		}
	}
	
	public boolean validateCourseId(String Id) throws InvalidCourseException
	{
		if(Pattern.matches("C[0123456789]+",Id))
		{
			return true;
		}
		else
		{
			throw new InvalidCourseException("Course with id "+Id+" is not valid");
		}
	}
	
	public String generateEid() 
	{
		n1++;
		String s="ENR"+n1;
		return s;
	}
	
	public String generatePayid() 
	{
		n2++;
		String s="PAY"+n2;
		return s;
	}
	
	public double calculateGpa(int[] m)
	{
		int sum=0;
		for(int a:m)
		{
			sum+=a;
			
		}
		double avg=sum/m.length;
		
		
		return avg;
	}
	
	public int calculatePercentage(int a,int b)
	{
		int p=(a*100)/b;
		//System.out.println(p);
		return p;
	}
	public java.util.Date findCurrentDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date=new java.util.Date();
		String s=sdf.format(date);
		return convertStringToDate(s);
	}
}
