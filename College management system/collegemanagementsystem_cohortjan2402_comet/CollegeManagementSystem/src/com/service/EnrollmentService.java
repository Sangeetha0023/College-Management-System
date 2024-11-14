package com.service;

import com.management.EnrollmentManagement;
import com.model.Enrollment;
import com.util.ApplicationUtil;

import java.util.*;

public class EnrollmentService 
{
	EnrollmentManagement em=new EnrollmentManagement();
	ApplicationUtil au=new ApplicationUtil();
	
	
	public boolean addEnrollment(String... enrollmentDetails)
	{
		List<Enrollment> elist=parseEnrollment(enrollmentDetails);
		if(em.addEnrollmentDetails(elist))
		{
			return true;
		}
		return false;
	}
	
	public boolean updateFeeStatus(String id,String sts)
	{
		if(em.updateEnrollmentDetails(id,sts))
		{
			return true;
		}
		return false;
	}
	
	public List<Enrollment> retrieveDetailsByCid(String id)
	{
		return em.viewEnrollmentDetailByCourseId(id);
	}
	
	public int updateStatus(String id) {
		return em.updateStatus(id);
	}
	public List<Enrollment> retreiveByFeeStatus(String feeStatus)
	{
		return em.viewEnrollmentDetailsByFeeStatus(feeStatus);
		
	}
	
	public boolean deleteEnrollment(String id)
	{
		if(em.deleteEnrollmentDetails(id))
		{
			return true;
		}
		return false;
	}
	public List<Enrollment> parseEnrollment(String... enrollmentDetails)
	{
		List<Enrollment> elist=new ArrayList<Enrollment>();
		
		for(int i=0;i<enrollmentDetails.length;i++)
		{
			String a[]=enrollmentDetails[i].split(":");
			String eid=au.generateEid();
			String sid=a[0];
			String cid=a[1];
			String sts=a[2];
			
			Enrollment en=new Enrollment(eid,sid,cid,sts);
			
			elist.add(en);
		}
		
		return elist;
		
	}
}
