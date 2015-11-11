package com.zghw.concurrent.core;

public class MyThread extends Thread {
	@Override
	public void run(){
		super.run();
		System.out.println("MyThread");
	}
}
