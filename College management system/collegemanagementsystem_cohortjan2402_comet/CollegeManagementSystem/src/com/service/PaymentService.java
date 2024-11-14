package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.PaymentManagement;
import com.management.StudentManagement;
import com.model.Enrollment;
import com.model.Payment;
import com.model.Student;

public class PaymentService {
	PaymentManagement pm=new PaymentManagement();

	public List<Enrollment> retrieveDetailsByEid(String id)
	{
		return pm.viewPaymentDetailByEnrollmentId(id);
	}
	
	public double calculateTotalFee()
	{
		return 0;
	}
   
	public List<Enrollment> retrieveEnrollment(String id){
		List<Enrollment> list=pm.viewPaymentDetailByEnrollmentId(id);
		
		return list;
	}
	public String findCourseId(String id) {
		return pm.findCourseId(id);
	}
	public double findCourseAmount(String id) {
		return pm.findCourseAmount(id);
	}
	public double calculateBillAmount(double amount,String studId) {
		StudentManagement smt=new StudentManagement();
		ArrayList<Student> studList=smt.viewStudentById(studId);
		double twelfth=0;
		double firstGrad=0;
		for(Student x:studList) {
			if(x.getFirstGraduate().equalsIgnoreCase("yes")) {
				firstGrad=amount*0.1;
			}
			if(x.getTwelfthGradeMark()>=80) {
				twelfth=amount*0.1;
			}
		}
		return amount-firstGrad-twelfth;
	}
	public int insertPaymentDetails(Payment obj) {
		return pm.insertPaymentDetails(obj);
	}
	
	public List<Payment> viewEnrollmentDetailByPaymentId(String id)
	{
		return pm.viewEnrollmentDetailByPaymentId(id);
	}
}
