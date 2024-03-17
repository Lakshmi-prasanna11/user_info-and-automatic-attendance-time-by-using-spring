package com.uli.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.uli.dao.AttendanceDao;
import com.uli.dao.EmployeeDao;
import com.uli.dto.Attendance;
import com.uli.dto.Employee;
import com.uli.service.MyConfig;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext app=new AnnotationConfigApplicationContext(MyConfig.class);
		
		Scanner scanner=(Scanner)app.getBean("getscanner");
		
		Employee employee=(Employee)app.getBean("employee");
		Attendance attendance=(Attendance)app.getBean("attendance");
		
		EmployeeDao employeeDao=(EmployeeDao)app.getBean("employeeDao");
		AttendanceDao attendanceDao=(AttendanceDao)app.getBean("attendanceDao");
		
		System.out.println("1.Register/n2.Login/n3.Exit");
		int option=scanner.nextInt();
		
		switch(option) {
		case 1:{
			System.out.println("Enter name");
			String name=scanner.next();
			System.out.println("Enter phoneno");
			long phone_no=scanner.nextLong();
			System.out.println("Enter password");
			String password=scanner.next();
			
			employee.setName(name);
			employee.setPhone_no(phone_no);
			employee.setPassword(password);
			
			employeeDao.saveEmployee(employee);
		}
		break;
		case 2:{
			System.out.println("Enter phoneno");
			long phone_no=scanner.nextLong();
			System.out.println("Enter password");
			String password=scanner.next();
			
			
			Employee employee1=employeeDao.findEmployeeByPhoneNoAndPassword(phone_no, password);
			if(employee1!=null) {
				
				attendanceDao.saveAttendance(attendance);
				
				List<Attendance> attendances=new ArrayList<Attendance>();
				attendances.add(attendance);
				
				employee1.setAttendance(attendances);
				employeeDao.updateEmployee(employee1);
			}
		}
		}
	}

}
