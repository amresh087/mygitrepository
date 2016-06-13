package com.java7_concurrency.pack7.semaphore;

public class Job implements Runnable {
	
	 private PrintQueue printQueue; 
	 
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	
	 public void run() {
		 System.out.println("%s: Going to print a job\n"+Thread. currentThread().getName()); 
		
		 printQueue.printJob(new Object());
		 
		  System.out.println("%s: The document has been printed "+Thread.currentThread().getName()); 
	 }

}
