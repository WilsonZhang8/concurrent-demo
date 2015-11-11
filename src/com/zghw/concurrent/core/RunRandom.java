package com.zghw.concurrent.core;

public class RunRandom {
	//說明線程是隨機的
	public static void main(String args[]) throws InterruptedException{
		MyThreadRandom mythread=new MyThreadRandom();
		mythread.setName("myThreadRandom");
		mythread.start();
		for(int i=0;i<10;i++){
			int time = (int) (Math.random()*1000);
			Thread.sleep(time);
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("run end!");
	}
}
