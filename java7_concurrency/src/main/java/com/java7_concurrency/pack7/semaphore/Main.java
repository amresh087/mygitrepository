package com.java7_concurrency.pack7.semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 PrintQueue printQueue=new PrintQueue();
		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}


	}

}
