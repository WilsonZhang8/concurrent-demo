package com.zghw.concurrent.core;

public class MyThreadSafe extends Thread{
	private int count =5;
	public MyThreadSafe(String name){
		super();
		this.setName(name);
	}
	
	@Override
	public void run(){
		super.run();
		while(count >0){
			count --;
			System.out.println(this.currentThread().getName()+"，count="+count);
		}
	}
}
