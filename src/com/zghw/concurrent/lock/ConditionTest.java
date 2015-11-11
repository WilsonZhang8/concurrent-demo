package com.zghw.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("开始等待");
			condition.await();
			System.out.println("得到通知");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		lock.lock();
		condition.signal();
		lock.unlock();
	}

	public static void main(String args[]) throws InterruptedException {
		final ConditionTest ct = new ConditionTest();
		Runnable rb = new Runnable() {
			@Override
			public void run() {
				ct.await();
			}
		};
		Thread t = new Thread(rb);
		t.start();
		Thread.sleep(1000);
		ct.signal();
	}
}
