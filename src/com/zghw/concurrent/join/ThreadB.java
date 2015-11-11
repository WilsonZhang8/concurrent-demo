package com.zghw.concurrent.join;

public class ThreadB extends Thread {
	@Override
	public void run(){
		try {
			ThreadA ta =new ThreadA();
			ta.start();
			ta.join();
			System.out.println("等待线程A执行完成了！");
		} catch (InterruptedException e) {
			System.out.println("等待线程A执行完成被打断！");
			e.printStackTrace();
		}
		
	}
}
