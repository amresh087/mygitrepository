package com.java7_concurrency.pack9.countdowlatch;

import java.util.concurrent.TimeUnit;

public class Participant  implements Runnable{
	
	
	 private Videoconference conference; 
	 private String name; 
	 
	public Participant(Videoconference conference, String name) {
		this.conference = conference;
		this.name = name;
	}
	
	
	 public void run() {
		 
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
			
			
			conference.arrive(name); 
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	
	

}
