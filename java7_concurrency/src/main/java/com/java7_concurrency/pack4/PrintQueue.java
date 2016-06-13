package com.java7_concurrency.pack4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	 private final Lock queueLock=new ReentrantLock(); 
	 
	 public void printJob1(Object document){ 
		 
		 queueLock.lock();
		 
		 
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during "+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally { 
			
			System.out.println("===================================unlock=============");
			queueLock.unlock();  
			} 
		 
		 
	 }

	

}
