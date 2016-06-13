package com.demo.resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
@Qualifier("applicationUser")
public class ApplicationUser {
	
	private String name;
	private int age;
	private String address;
	
	public void setInitValue(String name,int age,String address)
	{
		
		this.name=name;
		this.address=address;
		this.age=age;
	}
	
	
	
	public void showUserData()
	{
		System.out.println("user name is : "+name);
		System.out.println("user age is : "+age);
		System.out.println("user address is :"+address);
	}

}
