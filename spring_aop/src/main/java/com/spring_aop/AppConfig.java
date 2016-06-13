package com.spring_aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring_aop")
@EnableAspectJAutoProxy
public class AppConfig {
    // no explicit @Bean definitions required
	
	@Bean
	public EmployeeCRUDAspect loggingAspect()
	{
		return new EmployeeCRUDAspect();
	}
}