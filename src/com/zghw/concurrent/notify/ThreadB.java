package com.zghw.concurrent.notify;

public class ThreadB extends Thread{
	private Consumer c;
	public ThreadB(Consumer c){
		super();
		this.c = c;
	}
	
	@Override
	public void run(){
		while(true){
			c.get();
		}
	}
}
