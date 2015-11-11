package com.zghw.concurrent.lock;

public class MyThread extends Thread {
	private MyService ms;
	public MyThread(MyService ms){
		super();
		this.ms = ms;
	}
	@Override
	public void run(){
		ms.getMethod();
	}
}
