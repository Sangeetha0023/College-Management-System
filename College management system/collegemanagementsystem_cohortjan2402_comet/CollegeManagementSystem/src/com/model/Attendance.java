package com.model;

public class Attendance {
	private String attendanceId;
	private String studentId;
	private String enrollmentId;
	private int semester;
	private int totalworkingdays;
	private int presentdays;
	private int absentdays;
	private int attendancepercentage;
	public String getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getTotalworkingdays() {
		return totalworkingdays;
	}
	public void setTotalworkingdays(int totalworkingdays) {
		this.totalworkingdays = totalworkingdays;
	}
	public int getPresentdays() {
		return presentdays;
	}
	public void setPresentdays(int presentdays) {
		this.presentdays = presentdays;
	}
	public int getAbsentdays() {
		return absentdays;
	}
	public void setAbsentdays(int absentdays) {
		this.absentdays = absentdays;
	}
	public int getAttendancepercentage() {
		return attendancepercentage;
	}
	public void setAttendancepercentage(int attendancepercentage) {
		this.attendancepercentage = attendancepercentage;
	}
	public Attendance(String attendanceId, String studentId, String enrollmentId, int semester, int totalworkingdays,
			int presentdays, int absentdays, int attendancepercentage) {
		super();
		this.attendanceId = attendanceId;
		this.studentId = studentId;
		this.enrollmentId = enrollmentId;
		this.semester = semester;
		this.totalworkingdays = totalworkingdays;
		this.presentdays = presentdays;
		this.absentdays = absentdays;
		this.attendancepercentage = attendancepercentage;
	}
	

}
