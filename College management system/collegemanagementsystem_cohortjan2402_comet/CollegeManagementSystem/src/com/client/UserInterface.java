package com.client;
import java.util.*;
import com.service.*;
import com.exception.InvalidCourseException;
import com.exception.InvalidStudentException;
import com.management.CourseManagement;
import com.management.StudentManagement;
import com.model.Attendance;
import com.model.Course;
import com.model.Enrollment;
import com.model.Mark;
import com.model.Payment;
import com.model.Student;
import com.service.StudentService;
import com.util.ApplicationUtil;

public class UserInterface 
{
	//101:aswin:22-09-2002:2024:2024:85:54:yes:aswin@gmail.com:45677532
	public static void main(String a[]) throws InvalidStudentException
	{
		
//		System.out.println(ApplicationUtil.convertStringToDate("12-09-2000"));
		Scanner sc=new Scanner(System.in);
		int c=0;
		do
		{
		System.out.println("Welcome to College Management System");
		System.out.println("1.Student Module");
		System.out.println("2.Course Module");
		System.out.println("3.Enrollment Module");
		System.out.println("4.Attendance Module");
		System.out.println("5.Mark Module");
		System.out.println("6.Payment Module");
		System.out.println("7.Exit");
		
		System.out.println("Enter the choice");
		c=sc.nextInt();
		
		ApplicationUtil au = new ApplicationUtil();
		
		if(c==1)
		{
			int choice = 0;
			do
			{
				System.out.println("1.Insert Student Details");
				System.out.println("2.Update Student Details");
				System.out.println("3.Retrive Student Details based on year of study");
				System.out.println("4.Retrieve Student Details based on Student Id");
				System.out.println("5.Delete Student Details");
				System.out.println("6.Exit");
				
				System.out.println("Enter Your Choice");
				choice = sc.nextInt();
				StudentService ss= new StudentService();

				

				//ApplicationUtil au=new ApplicationUtil();

				
				if(choice==1)
				{
					System.out.println("Enter the number of students");
					int n= sc.nextInt();
					String arr[] = new String[n];
					System.out.println("Enter the student details");
					for(int i=0;i<n;i++)
					{
						arr[i]=sc.next();
					}
					if(ss.addStudentObject(arr))
					{
						System.out.println("the student record is inserted");
					}
					else
					{
						System.out.println("No records added");
					}
				}
				
				if(choice == 2)
				{
					System.out.println("Enter the Student Id");
					String id=sc.next();
					try {
						if(au.validateStudentId(id))
						{
							System.out.println("Enter the phone number to be updated");
							long phno=sc.nextLong();
							
							if(ss.updatePhoneNumber(id,phno))
							{
								System.out.println("Student phone number updated successfully");
							}
							else
							{
								System.out.println("Student phone number is not updated");
							}
						}
					} 
					catch (InvalidStudentException e) {
						System.out.println(e.getMessage());
					}
					
					
				}
				if(choice==3)
				{
					System.out.println("Enter the year of study");
					int year = sc.nextInt();
					ArrayList<Student> li = new ArrayList<Student>();
					li = ss.viewStudentByYearOfStudy(year);
					if(li.isEmpty())
					{
						System.out.println("No Student records available based on year of study");
					}
					else
					{
						for(Student s:li)
						{
							System.out.println("Admission number : "+s.getAdmissionNumber());
							System.out.println("Student Id : "+s.getStudentId());
							System.out.println("Student Name : "+s.getStudentName());
							System.out.println("Date of Birth : "+s.getDob());
							System.out.println("Year of study : "+s.getYearOfStudy());
							System.out.println("Year of joining : "+s.getYearOfJoining());
							System.out.println("Tenth grade mark : "+s.getTenthGradeMark());
							System.out.println("Twelfth grade mark : "+s.getTwelfthGradeMark());
							System.out.println("First Graduate : "+s.getFirstGraduate());
							System.out.println("Email Id : "+s.getEmailId());
							System.out.println("Phone Number : "+s.getPhoneNumber());
						}
					}
				}
				
				if(choice==4)
				{
					
					System.out.println("Enter the Student Id");
				    String studId = sc.next();

				    try {
						if(au.validateStudentId(studId))
						{
							ArrayList<Student> li = new ArrayList<Student>();
							li = ss.viewStudentById(studId);
							if(li.isEmpty())
							{
								System.out.println("No Student records available based on year of study");
							}
							else
							{
								for(Student s:li)
								{
									System.out.println("Admission number : "+s.getAdmissionNumber());
									System.out.println("Student Id : "+s.getStudentId());
									System.out.println("Student Name : "+s.getStudentName());
									System.out.println("Date of Birth : "+s.getDob());
									System.out.println("Year of study : "+s.getYearOfStudy());
									System.out.println("Year of joining : "+s.getYearOfJoining());
									System.out.println("Tenth grade mark : "+s.getTenthGradeMark());
									System.out.println("Twelfth grade mark : "+s.getTwelfthGradeMark());
									System.out.println("First Graduate : "+s.getFirstGraduate());
									System.out.println("Email Id : "+s.getEmailId());
									System.out.println("Phone Number : "+s.getPhoneNumber());
								}
							}
						}
					} 
				    catch (InvalidStudentException e) {
				    	System.out.println(e.getMessage());
					}
					

				    
				   

				}
				
				if(choice==5)
				{
					System.out.println("Enter the Student Id");
				    String stud = sc.next();
				    try {
						if(au.validateStudentId(stud))
						{
							if(ss.deleteStudentDetails(stud))
						    {
						    	System.out.println("Student details deleted successfully");
						    }
						    else
						    {
						    	System.out.println("Student details not deleted");
						    }
						}
					} 
				    catch (InvalidStudentException e) {
				    	System.out.println(e.getMessage());
					}
				    
				}
				
			}while(choice<=5);	
		}
		if(c==2)
		{
			CourseService cs=new CourseService();
			System.out.println("Course Details");
			int choice=0;
			do
			{
				System.out.println("Select the option");
				System.out.println("1.Insert the course record");
				System.out.println("2.Update the course fee using course id");
				System.out.println("3.Delete the course");
				System.out.println("4.Retrieve the course details using course id");
				System.out.println("5.Exit from course module");
				choice=sc.nextInt();
				if(choice==1)
				{
					System.out.println("Enter the number of records to be added");
					int n=sc.nextInt();
					
					String[] course = new String[n];
					
					System.out.println("Enter the course details");
					for(int i=0;i<n;i++)
					{
						course[i]=sc.next();
					}
					
					
					if(cs.addCourse(course))
					{
						System.out.println(n+" record inserted successfully");
					}
					else
					{
						System.out.println("Record insertion failed");
					}
				}
				if(choice==2)
				{
					System.out.println("Enter the Course Id");
					String id=sc.next();
					
					try
					{
						if(au.validateCourseId(id))
						{
						String s=cs.viewFee(id);
						System.out.println("Already Enrolled Fees : "+s);
						System.out.println("Whether you have to change fee or not \nPlease provide Yes/No");
						
						String y=sc.next();
						
						if("Yes".equalsIgnoreCase(y))
						{
							System.out.println("Enter the fee to be updated");
							double fee=sc.nextDouble();
							
							boolean b=cs.updateFee(id,fee);
							
							if(b)
							{
								System.out.println("Fee updated successfully");
							}
							else
							{
								System.out.println("Fee updation failed");
							}
						}
						}
					}
					catch(InvalidCourseException e)
					{
						System.out.println(e.getMessage());
					}
					
					
					
					
					
				}
				if(choice==3)
				{
					System.out.println("Enter the Course Id");
					String id=sc.next();
					
					try
					{
						if(au.validateCourseId(id))
						{
							boolean b=cs.deleteCourse(id);
							
							if(b)
							{
								System.out.println("Course details deleted successfully");
							}
							else
							{
								System.out.println("Course deletion failed");
							}
						}
					}
					catch(InvalidCourseException e)
					{
						System.out.println(e.getMessage());
					}
					
					
					
				}
				if(choice==4)
				{
					System.out.println("Enter the course id");
					String id=sc.next();
					
					try
					{
						if(au.validateCourseId(id))
						{
							List<Course> l=new ArrayList<Course>();
							l=cs.retrieveCourseData(id);
							
							if(l.isEmpty())
							{
								System.out.println("No records available");
							}
							else
							{
							
							for(Course p:l)
							{
								System.out.println("Course Id : "+p.getCourseId());
								System.out.println("Course Name : "+p.getCourseName());
								System.out.println("Course Coordinator : "+p.getCourseCoordinator());
								System.out.println("Course Department : "+p.getDepartment());
								System.out.println("Course Fee : "+p.getCourseFee());
							}
							}
						}
					}
					catch(InvalidCourseException e)
					{
						System.out.println(e.getMessage());
					}
					
					
				}
			}while(choice<=4);
		}
		
		if(c==3)
		{
			EnrollmentService es=new EnrollmentService();
			int choice=0;
			do
			{
				System.out.println("1.Insert Enrollment details");
				System.out.println("2.Update fee status based on Enrollment Id");
				System.out.println("3.Retrieve record based on Course Id");
				System.out.println("4.Retrieve record based on Fee status");
				System.out.println("5.Delete the record");
				System.out.println("6.Exit from Enrollment module");
				choice=sc.nextInt();
				if(choice==1)
				{
					System.out.println("Enter the number of records to be added");
					
					int enroll=sc.nextInt();
					String[] arr=new String[enroll];
					System.out.println("Enter the Enrollment details");
					for(int j=0;j<enroll;j++) 
					{
						arr[j]=sc.next();
					}
					if(es.addEnrollment(arr))
					{
						System.out.println("Record added");
					}
					else
					{
						System.out.println("failed to add record");
					}
				}
				
				if(choice==2)
				{
					System.out.println("Enter the Enrollment Id");
					String id=sc.next();
					
					System.out.println("Enter the fee status to be updated\n Provide Paid (or) Not-Paid");
					String fee=sc.next();
					
					if(es.updateFeeStatus(id,fee))
					{
						System.out.println("Fee status updated successfully");
					}
					else
					{
						System.out.println("Failed to update fee status");
					}
					
				}
				
				if(choice==3)
				{
					System.out.println("Enter the Course Id");
					String id=sc.next();
					
					List<Enrollment> l=es.retrieveDetailsByCid(id);
					
					if(l.isEmpty())
					{
						System.out.println("No records found");
					}
					else
					{
						for(Enrollment e:l)
						{
							System.out.println("Enrollment Id : "+e.getEnrollmentId());
							System.out.println("Student Id : "+e.getStudentId());
							System.out.println("Course Id : "+e.getCourseId());
							System.out.println("Fee Status : "+e.getFeeStatus());
						}
					}
				}
				
				if(choice==4)
				{
					 System.out.println("Enter the Fee Status\\n Provide Paid (or) Not-Paid");
					 String s=sc.next();
					 
					 List<Enrollment> l=es.retreiveByFeeStatus(s);
					 
					 if(l.isEmpty())
					 {
						 System.out.println("No record found");
					 }
					 else
					 {
						 for(Enrollment e:l)
						 {
							System.out.println("Enrollment Id : "+e.getEnrollmentId());
							System.out.println("Student Id : "+e.getStudentId());
							System.out.println("Course Id : "+e.getCourseId());
							System.out.println("Fee Status : "+e.getFeeStatus());
						 }
					 }
				}
				
				if(choice==5)
				{
					System.out.println("Enter the Enrollment Id to deleted");
					String s=sc.next();
					
					if(es.deleteEnrollment(s))
					{
						System.out.println("Record deleted successfully");
					}
					else
					{
						System.out.println("Record deletion failed");
					}
				}
			}while(choice<=5);
		}
		
		
		
		if(c==4)
		{

			int ch=0;
			do
			{
				System.out.println("1.Insert Attendance Details");
				System.out.println("2.Retrieve Attendance List by Student Id");
				System.out.println("3.Retrieve Attendance List by Attendance Id");
				System.out.println("4.Exit");
				
				System.out.println("Enter your choice");
				ch = sc.nextInt();
				AttendanceService as=new AttendanceService();
				
				if(ch==1)
				{
					  
					   System.out.println("Enter the number of records to be added");
					   int rec=sc.nextInt();
					   String[] details=new String[rec];
					   System.out.println("Enter the Attendance details");
					   for(int j=0;j<rec;j++)
					   {
						   details[j]=sc.next();
					   }
					   
					   if(as.addAttendance(details))
					   {
						 System.out.println("record to be added"); 
					   }
					   else 
					   {
						   System.out.println("record insertion failed");
					   }
					   
				}
				
				if(ch==2)
				{
					System.out.println("Enter the student Id");
					String sid = sc.next();
					
					try {
						if(au.validateStudentId(sid))
						{
							List<Attendance> lis = new ArrayList<Attendance>();
							lis = as.viewAttendanceByStudentId(sid);
							if(lis.isEmpty())
							{
								System.out.println("No records available");
							}
							else
							{
								for(Attendance att:lis)
								{
									System.out.println("Attendance Id"+att.getAttendanceId());
									System.out.println("Student Id : "+att.getStudentId());
									System.out.println("Enrollment Id : "+att.getEnrollmentId());
									System.out.println("Semester : "+att.getSemester());
									System.out.println("Total Working Days "+att.getTotalworkingdays());
									System.out.println("Present Days "+att.getPresentdays());
									System.out.println("Absent Days : "+att.getAbsentdays());
									System.out.println("Attendance Percentage :"+att.getAttendancepercentage());
									
								}
							}
						}
					} 
				    catch (InvalidStudentException e) {
				    	System.out.println(e.getMessage());
					}
				}
					
					if(ch==3)
					{
						System.out.println("Enter the Attendance Id");
						String aid = sc.next();
						
						
								List<Attendance> lis = new ArrayList<Attendance>();
								lis = as.viewAttendanceByAttendanceId(aid);
								if(lis.isEmpty())
								{
									System.out.println("No records available");
								}
								else
								{
									for(Attendance att:lis)
									{
										System.out.println("Attendance Id"+att.getAttendanceId());
										System.out.println("Student Id : "+att.getStudentId());
										System.out.println("Enrollment Id : "+att.getEnrollmentId());
										System.out.println("Semester : "+att.getSemester());
										System.out.println("Total Working Days "+att.getTotalworkingdays());
										System.out.println("Present Days "+att.getPresentdays());
										System.out.println("Absent Days : "+att.getAbsentdays());
										System.out.println("Attendance Percentage :"+att.getAttendancepercentage());
										
									}
								}
							}
						 
					    
					

			
			}while(ch<=3);

		  }
		
		if(c==5)
		{
			int temp=0;
			do
			{
				System.out.println("1.Insert Mark Details");
				System.out.println("2.Retrieve Mark Details based on Student Id");
				System.out.println("3.Retrive Mark Details based on semester");
				System.out.println("4.Update CGPA");
				System.out.println("5.Exit");
				
				System.out.println("Enter the choice");
				temp = sc.nextInt();
				
				MarkService ms=new MarkService();
				
				if(temp==1)
				{
					
					System.out.println("Enter the number of records to be added");
					int m=sc.nextInt();
					System.out.println("Enter the Mark details");
					String[] marks=new String[m];
					for(int i=0;i<m;i++) 
					{
						marks[i]=sc.next();
					}
					if(ms.addMarkObject(marks))
					{
						System.out.println("the marks record is inserted");	
					}
					else
					{
						System.out.println("No records added");
					}
				}
				
				if(temp==2)
				{
					System.out.println("Enter the Student Id");
					String s=sc.next();
					
					ArrayList<Mark> ml=ms.viewMarkByStudentId(s);
					
					if(ml.isEmpty())
					{
						System.out.println("No record found");
					}
					else
					{
						for(Mark u:ml)
						{
							System.out.println("Mark Id : "+u.getMarksId());
							System.out.println("Student Id : "+u.getStudentId());
							System.out.println("Semester : "+u.getSemester());
							System.out.println("Subject 1 : "+u.getSubject1());
							System.out.println("Subject 2 : "+u.getSubject2());
							System.out.println("Subject 3 : "+u.getSubject3());
							System.out.println("Subject 4 : "+u.getSubject4());
							System.out.println("Subject 5 : "+u.getSubject5());
							System.out.println("Subject 6 : "+u.getSubject6());
							System.out.println("Subject 7 : "+u.getSubject7());
							System.out.println("Subject 8 : "+u.getSubject8());
							System.out.println("GPA : "+u.getGpa());
							System.out.println("CGPA : "+u.getCgpa());
						}
					}
				}
				
				if(temp==3)
				{
					System.out.println("Enter the Semester");
					int s=sc.nextInt();
					
					
					ArrayList<Mark> ml=ms.viewMarkBySemester(s);
					
					if(ml.isEmpty())
					{
						System.out.println("No record found");
					}
					else
					{
						for(Mark u:ml)
						{
							System.out.println("Mark Id : "+u.getMarksId());
							System.out.println("Student Id : "+u.getStudentId());
							System.out.println("Semester : "+u.getSemester());
							System.out.println("Subject 1 : "+u.getSubject1());
							System.out.println("Subject 2 : "+u.getSubject2());
							System.out.println("Subject 3 : "+u.getSubject3());
							System.out.println("Subject 4 : "+u.getSubject4());
							System.out.println("Subject 5 : "+u.getSubject5());
							System.out.println("Subject 6 : "+u.getSubject6());
							System.out.println("Subject 7 : "+u.getSubject7());
							System.out.println("Subject 8 : "+u.getSubject8());
							System.out.println("GPA : "+u.getGpa());
							System.out.println("CGPA : "+u.getCgpa());
						}
					}
				}
				
				if(temp==4)
				{
					System.out.println("Enter the Semester");
					int s=sc.nextInt();
					
					System.out.println("Enter the CGPA");
					double c1=sc.nextDouble();
					if(ms.updateCgpa(c1,s))
					{
						System.out.println("Updated successfully");
						
					}
					else
					{
						System.out.println("Updation failed");
					}
				}
				
				
			}while(temp<=4);

			
		}
		
		if(c==6)
		{
			int t=0;
			do
			{
				PaymentService ps=new PaymentService();
				System.out.println("1.Payment");
				System.out.println("2.Retrieve");
				System.out.println("3.Exit");
				System.out.println("Enter your choice");
				t=sc.nextInt();
				if(t==1)
				{
					System.out.println("Enter the Enrollment Id");
					String id=sc.next();
					
					List<Enrollment> result=ps.retrieveEnrollment(id);
					if(result.isEmpty()) {
						System.out.println("No records found");
					}
					String courseId="";
					String studId="";
					for(Enrollment x:result) {
						if(x.getFeeStatus().equalsIgnoreCase("paid")) {
							System.out.println("Already paid");
						}
						else {
							courseId=x.getCourseId();
							studId=x.getStudentId();
							double amount=ps.findCourseAmount(courseId);
							double finalAmount=ps.calculateBillAmount(amount, studId);
							System.out.println("You have to pay : "+finalAmount);
							System.out.println("Enter Payment Mode");
							String paymentMode=sc.next();
							String paymentId=au.generatePayid();
							java.util.Date payDate=au.findCurrentDate();
							Payment pobj=new Payment(paymentId,id,payDate,paymentMode,finalAmount);
							int r=ps.insertPaymentDetails(pobj);
							if(r>0) {
								EnrollmentService es=new EnrollmentService();
								int r1=es.updateStatus(id);
								if(r1>0) {
								System.out.println("Payment paid successfully");
								}
							}
						}
					}
					
				}
				if(t==2)
				{
					System.out.println("Enter the Payment Id");
					String id=sc.next();
					
					List<Payment> l=ps.viewEnrollmentDetailByPaymentId(id);
					
					if(l.isEmpty())
					{
						System.out.println("No records found");
					}
					else
					{
						StudentService ss=new StudentService();
						for(Payment e:l)
						{
							List<Enrollment> list=ps.retrieveEnrollment(e.getEnrollmentId());
							String studId="";
							for(Enrollment e1:list) {
								studId=e1.getStudentId();
							}
							ArrayList<Student> li = new ArrayList<Student>();
							li = ss.viewStudentById(studId);
							String name="";
							for(Student s:li) {
								name=s.getStudentName();
							}
							System.out.println("Payment Id : "+e.getPaymentId());
							System.out.println("Student Id : "+studId);
							System.out.println("Student Name : "+name);
							System.out.println("Enrollment Id : "+e.getEnrollmentId());
							System.out.println("Payment Date : "+e.getPaymentDate());
							System.out.println("Payment Mode : "+e.getPaymentMode());
							System.out.println("Amount : "+e.getAmount());
						}
					}
				}
			}while(t<=2);
			
			
//			else if(result==1) {
//				String courseId=ps.findCourseId(id);
//				double amount=ps.findCourseAmount(courseId);
//				System.out.println("You have to pay : "+amount);
//				
//			}
//			List<Enrollment> l=ps.retrieveDetailsByEid(id);
//			
//			if(l.isEmpty())
//			{
//				System.out.println("No records found");
//			}
//			else
//			{
//				for(Enrollment e:l)
//				{
//					System.out.println("Enrollment Id : "+e.getEnrollmentId());
//					System.out.println("Student Id : "+e.getStudentId());
//					System.out.println("Course Id : "+e.getCourseId());
//					System.out.println("Fee Status : "+e.getFeeStatus());
//				}
//			}
			
		}
		if(c==7)
		{
			System.out.println("Thank you for using this Application");
			return;
		}
		}while(c<=7);
	
	
	}
}
