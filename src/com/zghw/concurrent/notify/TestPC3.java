package com.zghw.concurrent.notify;

public class TestPC3 {

	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ProductService ps = new ProductService(ms);
		ConsumerService cs = new ConsumerService(ms);
		ProductThread pt =new ProductThread(ps);
		pt.setName("product 0");
		ConsumerThread ct = new ConsumerThread(cs);
		ct.setName("consumer 0");
		pt.start();
		ct.start();
		
		ProductThread pt1 =new ProductThread(ps);
		pt1.setName("product 1");
		ProductThread pt2 =new ProductThread(ps);
		pt2.setName("product 2");
		ProductThread pt3 =new ProductThread(ps);
		pt3.setName("product 3");
		ProductThread pt4 =new ProductThread(ps);
		pt4.setName("product 4");
		ProductThread pt5 =new ProductThread(ps);
		pt5.setName("product 5");
		pt1.start();
		pt2.start();
		pt3.start();
		pt4.start();
		pt5.start();
	}

}
