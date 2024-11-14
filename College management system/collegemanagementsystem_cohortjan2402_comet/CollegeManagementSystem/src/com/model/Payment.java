package com.model;
import java.util.*;

public class Payment {
	
	private String paymentId;
	private String enrollmentId;
	private Date paymentDate;
	private String paymentMode;
	private double amount;
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Payment(String paymentId, String enrollmentId, Date paymentDate, String paymentMode, double amount) {
		super();
		this.paymentId = paymentId;
		this.enrollmentId = enrollmentId;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.amount = amount;
	}
	
	
	
}
