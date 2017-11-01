package com.jerry.myapp.thread;

public class TestMain extends Thread {

	@Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" hello world");
        Singleton sg = Singleton.getInstance();
        System.out.println(sg);
    }
        
    public static void main(String[] args) {
        TestMain t1 = new TestMain();
        TestMain t2 = new TestMain();
        TestMain t3 = new TestMain();
        TestMain t4 = new TestMain();
        TestMain t5 = new TestMain();
        t1.start();
        t2.start();
        /*t3.start();
        t4.start();
        t5.start();*/
    }
    
}
