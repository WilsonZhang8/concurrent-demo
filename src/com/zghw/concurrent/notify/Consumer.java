package com.zghw.concurrent.notify;

public class Consumer {
	private String value;

	public Consumer(String value) {
		this.value = value;
	}

	public void get() {
		synchronized(value){
			try {
				if (ObjectValue.value.equals("")) {
					System.out.println("消费者"+Thread.currentThread().getId()+" -- "+"线程"+Thread.currentThread().getName()+" wait!####");
					
					value.wait();
				}
				System.out.println("消费者"+Thread.currentThread().getId()+" -- "+"线程"+Thread.currentThread().getName()+" Runnable");
				//System.out.println("get "+ObjectValue.value);
				String value="";
				ObjectValue.value=value;
				value.notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
