package com.zghw.concurrent.core;

public class ThreadMethod extends Thread {
	//currentThread()方法可以返回代码段正在被那个线程调用信息。
	//isAlive()的作用用来测试线程是否处于活动状态。
	//getId()方法的作用是取得線程的唯一標誌
	//sleep()方法作用是在指定的毫秒數中讓當前“正在執行的線程休眠”
	public ThreadMethod(){
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
		System.out.println("Thread.currentThread().getId()="+Thread.currentThread().getId());
		System.out.println("this.getName="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("this.getId()="+this.getId());
	}
	@Override
	public void run (){
		System.out.println("run--begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
		System.out.println("Thread.currentThread().getId()="+Thread.currentThread().getId());
		System.out.println("this.getName="+this.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("this.getId()="+this.getId());
		System.out.println("run---end");
	}
	public static void main(String[] args){
		//类的构造方法时被main线程调用的，而run方法是被Thread-0的线程调用的。
		ThreadMethod tm =new ThreadMethod();
		Thread t=new Thread(tm);
		System.out.println("main begin t1 isAlive="+t.isAlive());
		t.setName("a");
		t.start();
		System.out.println("main end t1 isAlive="+t.isAlive());
	}
}
