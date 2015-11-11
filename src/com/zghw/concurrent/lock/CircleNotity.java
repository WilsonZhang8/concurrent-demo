package com.zghw.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CircleNotity {
	private static volatile int index = 1;
	private static ReentrantLock rc = new ReentrantLock();
	private static final Condition cdt1 = rc.newCondition();
	private static final Condition cdt2 = rc.newCondition();
	private static final Condition cdt3 = rc.newCondition();

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				try {
					rc.lock();
					while (index != 1) {
						cdt1.await();
					}
					for (int i = 0; i < 5; i++) {
						//System.out.println(Thread.currentThread().getName()+"A任务 " + i);
					}
					index = 2;
					System.out.println(Thread.currentThread().getName()+"A任务 通知2号");
					cdt2.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					rc.unlock();
				}
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				try {
					rc.lock();
					while (index != 2) {
						cdt2.await();
					}
					for (int i = 0; i < 5; i++) {
						//System.out.println(Thread.currentThread().getName()+"B任务 " + i);
					}
					index = 3;
					System.out.println(Thread.currentThread().getName()+"B任务 通知3号");
					cdt3.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					rc.unlock();
				}
			}
		};
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				try {
					rc.lock();
					while (index != 3) {
						cdt3.await();
					}
					for (int i = 0; i < 5; i++) {
						//System.out.println(Thread.currentThread().getName()+"C任务 " + i);
					}
					index = 1;
					System.out.println(Thread.currentThread().getName()+"C任务 通知1号");
					cdt1.signalAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					rc.unlock();
				}
			}
		};
		for (int i = 0; i < 5; i++) {
			Thread t1 = new Thread(r1);
			t1.setName("第"+i+"个");
			Thread t2 = new Thread(r2);
			t2.setName("第"+i+"个");
			Thread t3 = new Thread(r3);
			t3.setName("第"+i+"个");
			t1.start();
			t2.start();
			t3.start();
		}
	}

}
