package com.zghw.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionMuliTest {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Condition conditionB = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"开始等待");
			condition.await();
			System.out.println("线程"+Thread.currentThread().getName()+"得到通知");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		lock.lock();
		condition.signalAll();
		lock.unlock();
	}

	
	public void awaitB() {
		try {
			lock.lock();
			System.out.println("线程"+Thread.currentThread().getName()+"开始等待");
			conditionB.await();
			System.out.println("线程"+Thread.currentThread().getName()+"得到通知");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll_B() {
		lock.lock();
		conditionB.signalAll();
		lock.unlock();
	}
	
	public static void main(String args[]) throws InterruptedException {
		final ConditionMuliTest ct = new ConditionMuliTest();
		Runnable rb = new Runnable() {
			@Override
			public void run() {
				ct.await();
			}
		};
		Runnable rbb = new Runnable() {
			@Override
			public void run() {
				ct.awaitB();
			}
		};
		Thread t = new Thread(rb);
		t.setName("A");
		t.start();
		Thread tb = new Thread(rbb);
		tb.setName("B");
		tb.start();
		Thread.sleep(1000);
		ct.signalAll_B();
	}
}
