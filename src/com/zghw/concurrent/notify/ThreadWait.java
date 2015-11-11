package com.zghw.concurrent.notify;

public class ThreadWait extends Thread{
	private MyObject obj;
	
	public ThreadWait(MyObject obj){
		super();
		this.obj = obj; 
	}
	@Override
	public void run(){
		try {
			synchronized (obj) {
				System.out.println("开始   wait time = "
						+ System.currentTimeMillis());
				obj.wait();
				System.out.println("结束  wait time ="
						+ System.currentTimeMillis()+" list 集合中元素个数："+obj.getSize());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
