package com.demo4.logger;

import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

public class MyLogger {
	
	public static void main(String[] args) {
		Logger logger = new Logger();
		
		System.out.println("============="+logger);
		 logger.addListener (new SimpleLogListener (System.out));

		
		
	}

}
