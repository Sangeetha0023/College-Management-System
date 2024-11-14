package com.model;

public class Mark {
    private String marksId;
	private String studentId;
    private int semester;
    private String subject1;
    private String subject2;
    private String subject3; 
    private String subject4;
    private String subject5;
    private String subject6;
    private String subject7;
    private String subject8;
    private double gpa;
    private double cgpa;
    
    
	//attributes for marks
     
     public String getMarksId() {
		return marksId;
	}
	public void setMarksId(String marksId) {
		this.marksId = marksId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	public String getSubject3() {
		return subject3;
	}
	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}
	public String getSubject4() {
		return subject4;
	}
	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}
	public String getSubject5() {
		return subject5;
	}
	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}
	public String getSubject6() {
		return subject6;
	}
	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}
	public String getSubject7() {
		return subject7;
	}
	public void setSubject7(String subject7) {
		this.subject7 = subject7;
	}
	public String getSubject8() {
		return subject8;
	}
	public void setSubject8(String subject8) {
		this.subject8 = subject8;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public Mark(String marksId, String studentId, int semester, String subject1, String subject2, String subject3,
			String subject4, String subject5, String subject6, String subject7, String subject8, double gpa,
			double cgpa) {
		super();
		this.marksId = marksId;
		this.studentId = studentId;
		this.semester = semester;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.subject6 = subject6;
		this.subject7 = subject7;
		this.subject8 = subject8;
		this.gpa = gpa;
		this.cgpa = cgpa;
	}
	
	
	
	
     
     
     
}
