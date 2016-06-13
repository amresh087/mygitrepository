package com.java7_concurrency.pack13.excutor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server server=new Server();
		for (int i=0; i<100; i++){
			 Task task=new Task("Task "+i);
			 server.executeTask(task);
		 }
		server.endServer();

	}

}
