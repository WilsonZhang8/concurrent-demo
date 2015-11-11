package com.zghw.concurrent.core;

public class RunShare {
	//共享數據的情況就是多個線程可以訪問同一個變量 產生非線程安全的問題
	public static void main(String args[]){
		MyThreadShare mythread=new MyThreadShare();
		Thread a=new Thread(mythread,"A");
		Thread b=new Thread(mythread,"B");
		Thread c=new Thread(mythread,"C");
		a.start();
		b.start();
		c.start();
	}
}
