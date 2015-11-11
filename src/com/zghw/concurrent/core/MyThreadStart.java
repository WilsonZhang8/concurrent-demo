package com.zghw.concurrent.core;

public class MyThreadStart extends Thread{
	private int i;
	public MyThreadStart(int i){
		super();
		this.i=i;
	}
	
	@Override
	public void run(){
		System.out.println(i);
	}
	
}
