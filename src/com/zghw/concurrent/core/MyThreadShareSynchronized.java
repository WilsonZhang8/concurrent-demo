package com.zghw.concurrent.core;

public class MyThreadShareSynchronized extends Thread{
	private int count =5;
	@Override
	synchronized public void run(){
		super.run();
		while(count >0){
			count --;
			System.out.println(this.currentThread().getName()+"，count="+count);
		}
	}
}
