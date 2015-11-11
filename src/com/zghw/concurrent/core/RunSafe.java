package com.zghw.concurrent.core;

public class RunSafe {
	//變量不共享每個線程有各自的count變量值，自己減少自己的count變量值
	public static void main(String args[]){
		MyThreadSafe a=new MyThreadSafe("A");
		MyThreadSafe b=new MyThreadSafe("B");
		MyThreadSafe c=new MyThreadSafe("C");
		a.start();
		b.start();
		c.start();
	}
}
