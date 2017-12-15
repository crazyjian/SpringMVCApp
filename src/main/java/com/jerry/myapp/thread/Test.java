package com.jerry.myapp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	
	 public static void main(String[] args) throws InterruptedException, ExecutionException {   
	/*	 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		 
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
		  }*/
		  
		 /* ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3); 
		  
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
		 new  Test().exec();
     }
	 
	 void exec() throws InterruptedException, ExecutionException{
		    //进行异步任务列表
		    List<FutureTask<Integer>> futureTasks = new ArrayList<FutureTask<Integer>>();
		    List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		    //线程池 初始化十个线程 和JDBC连接池是一个意思 实现重用 
		    ExecutorService executorService = Executors.newFixedThreadPool(10);
		    long start = System.currentTimeMillis();
		    //类似与run方法的实现 Callable是一个接口，在call中手写逻辑代码
		    Callable<Integer> callable = new Callable<Integer>() {
		    	
		    	private int a;
		      @Override
		      public Integer call() throws Exception {
		        Integer res = new Random().nextInt(100);
		        Thread.sleep(1000);
		        System.out.println("任务执行:获取到结果 :"+res);
		        return  res;
		      }
		    };
		    
		    for(int i=0;i<10;i++){
		      //创建一个异步任务
		      FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		      futureTasks.add(futureTask);
		      //提交异步任务到线程池，让线程池管理任务 特爽把。
		             //由于是异步并行任务，所以这里并不会阻塞
		     //executorService.submit(futureTask); 
		     Future<Integer> future = executorService.submit(callable); 
		     futures.add(future);
		    }
		    
		    int count = 0;
		  /*  for (FutureTask<Integer> futureTask : futureTasks) {
		         //futureTask.get() 得到我们想要的结果 
		         //该方法有一个重载get(long timeout, TimeUnit unit) 第一个参数为最大等待时间，第二个为时间的单位
		         count+= futureTask.get();
		    }*/
		    for(Future<Integer> f : futures) {
		    	count+=f.get();
		    }
		     long end = System.currentTimeMillis();
		     System.out.println("线程池的任务全部完成:结果为:"+count+"，main线程关闭，进行线程的清理");
		     System.out.println("使用时间："+(end-start)+"ms");
		     //清理线程池 
		     executorService.shutdown();
		    
		  }
	 
}
