package com.zghw.concurrent.notify;

/**
 * 一个生产者与多个消费者
 * @author zghw
 *
 */
public class TestPC2 {

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
		
		ConsumerThread ct1 = new ConsumerThread(cs);
		ct1.setName("consumer 1");
		ConsumerThread ct2 = new ConsumerThread(cs);
		ct2.setName("consumer 2");
		ConsumerThread ct3 = new ConsumerThread(cs);
		ct3.setName("consumer 3");
		ConsumerThread ct4 = new ConsumerThread(cs);
		ct4.setName("consumer 4");
		ConsumerThread ct5 = new ConsumerThread(cs);
		ct5.setName("consumer 5");
		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();
		ct5.start();
	}

}
