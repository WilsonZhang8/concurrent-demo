package com.zghw.concurrent.notify;

public class ThreadNotify extends Thread{

	private MyObject obj;
	public ThreadNotify(MyObject obj){
		super();
		this.obj = obj;
	}
	
	@Override
	public void run(){
		synchronized(obj){
			System.out.println("通知 开始时间："+System.currentTimeMillis());
			for(int i=0;i<10;i++){
				
				obj.add(i);
				System.out.println("添加了几个数量："+obj.getSize());
				if(obj.getSize()==5){
					obj.notify();
					System.out.println("通知结束时间："+System.currentTimeMillis()+"当前对象数量："+obj.getSize());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		}
	}
}
