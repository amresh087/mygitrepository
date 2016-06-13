package com.java7_concurrency.pack2;

public class PrimeGenerator extends Thread{
	
	
	public void run() 
	{    
		long number=1L;   
		while (true) 
		{      
			if (isPrime(number)) {       
				System.out.println("Number is Prime "+number);
			}
			if (isInterrupted()) {
				System.out.println("The Prime Generator has been Interrupted");
				return;
			}
			number++;

		}
	}
	
	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("====================");
		Thread task = new PrimeGenerator();
		task.start();
		System.out.println("================going to sleep=======");
		try {
			Thread.sleep(10);
			
			System.out.println("---------------------------------------------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("================going to intrapt=======");
		task.interrupt(); 

	}

}
