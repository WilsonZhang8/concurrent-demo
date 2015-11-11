package com.zghw.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	/**
	 * Lock具有同步的效果
	 */
	private Lock lock = new ReentrantLock();
	
	public void getMethod(){
		lock.lock();
		for(int i=0;i<1000;i++){
			int str=i++;
			System.out.print(" "+str);
		}
		System.out.println();
		lock.unlock();
	}
	
	public void methodA(){
		try {
			lock.lock();
			System.out.println("method A begin "+ Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("method A end "+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void methodB(){
		try {
			lock.lock();
			System.out.println("method B begin "+ Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("method B end "+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//lock.unlock();
		}
	}
}
