package com.zghw.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest1 {
	private boolean hasValue = false;
	public ReentrantLock lock;
	private Condition condition;

	public ConditionTest1() {
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}

	public ConditionTest1(boolean isFair) {
		lock = new ReentrantLock(isFair);
		condition = lock.newCondition();
	}

	public void set() {
		try {
			lock.lock();
			System.out.println(hasValue);
			while (hasValue) {
				System.out.println("await开始等待");
				condition.await();
			}
			System.out.println("*当前锁定的个数："+lock.getHoldCount());
			System.out.println("有没有线程数await等待："+lock.hasWaiters(condition) +"  await等待数："+lock.getWaitQueueLength(condition));
			hasValue = true;
			System.out.println("得到通知 公平锁情况："+lock.isFair());
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void get() {
		try {
			System.out.println("before当前线程是否被lock  "+lock.isHeldByCurrentThread()+" 当前的锁是否由任意线程保持： "+lock.isLocked());
			lock.lock();
			System.out.println("after当前线程是否被lock  "+lock.isHeldByCurrentThread()+" 当前的锁是否由任意线程保持： "+lock.isLocked());
			while (!hasValue) {
				System.out.println("signal开始等待");
				condition.await();
			}
			System.out.println("#获取处于等待锁的个数："+lock.getQueueLength());
			hasValue = false;
			condition.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String args[]) throws InterruptedException {
		final ConditionTest1 ct = new ConditionTest1(true);
		Runnable rb = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						if (Thread.currentThread().interrupted()) {
							throw new InterruptedException();
						}
						ct.set();
					}
				} catch (InterruptedException e) {
					System.out.println("rb线程已经停止");
					// e.printStackTrace();
				}
			}
		};
		Runnable rbb = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						if (Thread.currentThread().interrupted()) {
							throw new InterruptedException();
						}
						ct.get();
					}
				} catch (InterruptedException e) {
					System.out.println("rbb线程已经停止");
					// e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(rb);
		t.start();
		Thread.sleep(1000);
		Thread tb = new Thread(rbb);
		tb.start();
		
		Thread[] t1= new Thread[10];
		Thread[] t2 = new Thread[10];
		for(int i=0;i<10 ;i++){
			t1[i]=new Thread(rb);
			t2[i]=new Thread(rbb);
			t1[i].start();
			t2[i].start();
		}
	}
}
