package com.zghw.concurrent.notify;

public class ThreadA extends Thread{
	private Product p;
	public ThreadA(Product p){
		super();
		this.p = p;
	}
	
	@Override
	public void run(){
		while(true){
			p.set();
		}
	}
}
