package com.java7_concurrency.pack5;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 PricesInfo pricesInfo=new PricesInfo(); 
		 
		//Reader readers[] = new Reader[5];
		//Thread threadsReader[] = new Thread[5];
		
		
			Reader readers = new Reader(pricesInfo);
			Thread threadsReader = new Thread(readers);
		
		
		
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);
		
		
			threadsReader.start();
		
		threadWriter.start();


	}

}
