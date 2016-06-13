package com.amresh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amresh.core.CustomerBo;
import com.amresh.work.Worker;

@Configuration
@ComponentScan({"com.amresh.core"})
public class CustomerConfig {
	
	@Bean(name="customer")
	public CustomerBo customerBro()
	{
		return new CustomerBo();
	}
	
	@Bean(name="work")
	public Worker customerBro1()
	{
		return new Worker();
	}
	

}
