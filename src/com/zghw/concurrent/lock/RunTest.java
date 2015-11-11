package com.zghw.concurrent.lock;

public class RunTest {

	public static void main(String[] args) {
		muliThread();
	}
	public static void muliThread(){
		final MyService ms =new MyService();
		Runnable runa =new Runnable(){
			@Override
			public void run() {
				ms.methodA();
			}
		};
		Runnable runaa =new Runnable(){
			@Override
			public void run(){
				ms.methodA();
			}
		};
		
		Runnable runb = new Runnable(){
			@Override
			public void run(){
				ms.methodB();
			}
		};
		Runnable runbb = new Runnable(){
			@Override
			public void run(){
				ms.methodB();
			}
		};
		Thread ta = new Thread(runa);
		ta.setName("a");
		ta.start();
		Thread taa = new Thread(runaa);
		taa.setName("aa");
		taa.start();
		
		Thread tb = new Thread(runb);
		tb.setName("b");
		tb.start();
		Thread tbb = new Thread(runbb);
		tbb.setName("bb");
		tbb.start();
	}
}
