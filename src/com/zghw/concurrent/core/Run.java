package com.zghw.concurrent.core;

public class Run {
	//代碼的運行結果與代碼的執行順序或調用順序是無關的。
	public static void main(String args[]){
		MyThread mythread=new MyThread();
		mythread.start();
		System.out.println("run end!");
	}
}
