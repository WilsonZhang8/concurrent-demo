package com.zghw.concurrent.distribute;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
	volatile private boolean prevIsA = false;
	private AtomicInteger a=new AtomicInteger(0);
	private AtomicInteger b=new AtomicInteger(0);

	synchronized public void custumerA() {
		try {
			while (prevIsA) {
				this.wait();
			}
			String str = "AAAAAAAAAAAAAA"+a.incrementAndGet();
			storeA(str);
			this.prevIsA=true;
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	synchronized public void custumerB() {
		try {
			while (!prevIsA) {
				this.wait();
			}
			String str = "BBBBBBBBBBBBBB"+b.incrementAndGet();
			storeB(str);
			this.prevIsA=false;
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void storeA(String str) {
		System.out.println("存储到数据库A中:" + str);
	}

	private void storeB(String str) {
		System.out.println("存储到数据库B中:" + str);
	}
}
