package com.student;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mystudent")
public class Student {
	
	private String name;
	private int age;
	private String address;
	
	
	public void setStudentData(String name,int age,String address)
	{
		
		this.name=name;
		this.age=age;
		this.address=address;
		
	}
	
	public void showStudentData()
	{
		System.out.println("student name is : "+name);
		System.out.println("student age is : "+age);
		System.out.println("student address is : "+address);
	}
	
	

}
