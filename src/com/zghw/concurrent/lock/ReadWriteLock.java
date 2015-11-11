package com.zghw.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public void read() {
		readWriteLock.readLock().lock();
		try {
			System.out.println("读取操作" + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		readWriteLock.readLock().unlock();
	}

	public void write() {
		readWriteLock.writeLock().lock();
		try {
			System.out.println("写入操作" + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		readWriteLock.writeLock().unlock();
	}

	public static void main(String args[]) {
		final ReadWriteLock lock=new ReadWriteLock();
		Runnable r1 =new Runnable(){
			@Override
			public void run() {
				lock.read();
			}
		};
		Runnable r2 =new Runnable(){
			@Override
			public void run() {
				lock.write();
			}
		};
		
		Thread t1=new Thread(r2);
		Thread t2 =new Thread(r1);
		t1.start();
		t2.start();
	}
}
