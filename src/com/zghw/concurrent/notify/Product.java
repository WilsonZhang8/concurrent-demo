package com.zghw.concurrent.notify;

public class Product {
	private String value;

	public Product(String value) {
		this.value = value;
	}

	public void set() {
		synchronized(value){
			try {
				if (!ObjectValue.value.equals("")) {
					System.out.println("生产者"+Thread.currentThread().getId()+" -- "+"线程"+Thread.currentThread().getName()+" wait!####");
					value.wait();
				}
				System.out.println("生产者"+Thread.currentThread().getId()+" -- "+"线程"+Thread.currentThread().getName()+" Runnable");
				String v=System.currentTimeMillis()+" - "+System.nanoTime();
				ObjectValue.value=v;
				//System.out.println("set "+ObjectValue.value);
				value.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
