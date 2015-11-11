package com.zghw.concurrent.notify;

public class ConsumerThread extends Thread {
	private ConsumerService cs;
	public ConsumerThread(ConsumerService cs){
		super();
		this.cs = cs;
	}
	@Override
	public void run(){
		while(true){
			cs.pop();
		}
	}
}
