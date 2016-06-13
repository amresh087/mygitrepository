package com.spring_appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amresh.config.AppConfig;
import com.amresh.core.CustomerBo;
import com.amresh.core.SchedulerBo;
import com.amresh.work.Worker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
      
      
      CustomerBo custobj=(CustomerBo)context.getBean("customer");
      custobj.printMsg("hi custumer");
      
      
     SchedulerBo schedobj= (SchedulerBo)context.getBean("scheduler");
     schedobj.printMsg("hi scheduler");
     
     
     Worker workobj= (Worker)context.getBean("work");
     workobj.printMsg("hi worker");
      
      
      
    }
}
