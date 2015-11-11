package com.zghw.concurrent.join;

public class ThreadC extends Thread {
	private ThreadB tb;
	public ThreadC(ThreadB tb){
		super();
		this.tb = tb;
	}

	@Override
	public void run(){
		tb.interrupt();
	}
}
