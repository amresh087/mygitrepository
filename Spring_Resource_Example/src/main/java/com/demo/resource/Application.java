package com.demo.resource;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.student.Student;


@Component("application")
public class Application {
	
	//@Resource
	@Autowired
	@Qualifier("applicationUser")
    private ApplicationUser user;
	
	
	@Resource
	@Qualifier("mystudent")
    private Student student;
	
	public void operationPerformed()
	{
		System.out.println("===============setting value ============");
		user.setInitValue("amresh verma",27,"pratapgrah");
		
		System.out.println("===============display value ============");
		
		user.showUserData();
		
		
		
		
	}
	
	
	public void studentOperation()
	{
		student.setStudentData("anil sharma ",29,"faizabad");
		student.showStudentData();
	}
	
	
	

	
	

}
