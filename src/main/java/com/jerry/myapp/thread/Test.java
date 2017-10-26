package com.jerry.myapp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	
	 public static void main(String[] args) {   
		 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		 
		  for (int i = 0; i < 100; i++) {  
			   final int index = i;
			   try {  
			    Thread.sleep(2000);  
			   } catch (InterruptedException e) {  
			    e.printStackTrace();  
			   }
			   cachedThreadPool.execute(new Runnable() {

				   public void run() {  
					   try {  
						   while(true) {  
							   System.out.println(index);  
							   Thread.sleep(10 * 1000);  
						   }  
					   } catch (InterruptedException e) {  
						   e.printStackTrace();  
				       }  
				   }  
			   }); 
		  }
		  
		  /*ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3); 
		  
		  for (int i = 0; i < 10; i++) {  
			  final int index = i;  
			  fixedThreadPool.execute(new Runnable() {  
				  public void run() {  
					  try {  
						  System.out.println(index);  
						  Thread.sleep(2000);  
					  } catch (InterruptedException e) {  
			    	  	  e.printStackTrace();  
					  }  
			     }  
			  });  
		}
		  fixedThreadPool.shutdown();*/
		  
		  /*ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
		  scheduledThreadPool.scheduleAtFixedRate(new Runnable() {  
			  public void run() {  
				  System.out.println("delay 1 seconds, and excute every 3 seconds");  
			  }  
		  }, 1, 3, TimeUnit.SECONDS); */ 
		  
		/*  ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();  
		  for (int i = 0; i < 10; i++) {  
		  final int index = i;  
		  	singleThreadExecutor.execute(new Runnable() {  
		  		public void run() {  
		  			try {  
		  				System.out.println(index);  
		  				Thread.sleep(2000);  
		  			} catch (InterruptedException e) {  
		  				e.printStackTrace();  
		  			}  
		  		}  
		  	 });  
		  } */ 
		  
     }
	 
}
