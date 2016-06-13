package com.amresh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amresh.core.SchedulerBo;

@Configuration
@ComponentScan({"com.amresh.core"})
public class SchedulerConfig {
	@Bean(name="scheduler")
	public SchedulerBo schedulerBro()
	{
		return new SchedulerBo();
	}

}
