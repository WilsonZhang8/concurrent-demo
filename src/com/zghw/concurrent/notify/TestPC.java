package com.zghw.concurrent.notify;

public class TestPC {
	public static void main(String args[]) {
		try {
			String s = "";
			Product p = new Product(s);
			Consumer c = new Consumer(s);
			ThreadA ta = new ThreadA(p);
			ta.setName("product1");
			ThreadB tc = new ThreadB(c);
			tc.setName("consumer1");
			ThreadA ta2 = new ThreadA(p);
			ta2.setName("product2");
			ThreadB tc2 = new ThreadB(c);
			tc2.setName("consumer2");
			ta.start();
			tc.start();
			ta2.start();
			tc2.start();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
