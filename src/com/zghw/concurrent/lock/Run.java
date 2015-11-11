package com.zghw.concurrent.lock;

public class Run {

	public static void main(String[] args) {
		MyService ms = new MyService();
		MyThread mt1=new MyThread(ms);
		MyThread mt2=new MyThread(ms);
		MyThread mt3=new MyThread(ms);
		MyThread mt4=new MyThread(ms);
		MyThread mt5=new MyThread(ms);
		
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		mt5.start();
	}

}
