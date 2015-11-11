package com.zghw.concurrent.core;

public class RunStart {
	//說明線程啟動順序與start()執行順序無關
	public static void main(String args[]) throws InterruptedException{
		MyThreadStart mythread1=new MyThreadStart(1);
		MyThreadStart mythread2=new MyThreadStart(2);
		MyThreadStart mythread3=new MyThreadStart(3);
		MyThreadStart mythread4=new MyThreadStart(4);
		MyThreadStart mythread5=new MyThreadStart(5);
		MyThreadStart mythread6=new MyThreadStart(6);
		MyThreadStart mythread7=new MyThreadStart(7);
		MyThreadStart mythread8=new MyThreadStart(8);
		MyThreadStart mythread9=new MyThreadStart(9);
		MyThreadStart mythread10=new MyThreadStart(10);
		MyThreadStart mythread11=new MyThreadStart(11);
		MyThreadStart mythread12=new MyThreadStart(12);
		MyThreadStart mythread13=new MyThreadStart(13);
		mythread1.start();
		mythread2.start();
		mythread3.start();
		mythread4.start();
		mythread5.start();
		mythread6.start();
		mythread7.start();
		mythread8.start();
		mythread9.start();
		mythread10.start();
		mythread11.start();
		mythread12.start();
		mythread13.start();
		
	}
}
