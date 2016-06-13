package com.Spring_Resource_Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.AppConfig;
import com.demo.resource.Application;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    
    	//Byname Autowiring
    	Application obj =(Application)context.getBean("application");
    	
    	System.out.println("===================");
    	
    	obj.operationPerformed();
    	
    	System.out.println("-----------------------------");
    	obj.studentOperation();
    	
    	
    	
    	
    	
    	
    	
    	
    	
       
       
    }
}
