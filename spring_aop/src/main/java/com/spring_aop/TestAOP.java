package com.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);		
		
		System.out.println("========================");
		EmployeeManager manager = context.getBean(EmployeeManager.class);
		 
        manager.getEmployeeById(1);
        manager.createEmployee(new EmployeeDTO());

	}

}
