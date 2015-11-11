package com.zghw.concurrent.join;

public class MyThread extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("线程" + Thread.currentThread().getName()
					+ "开始运行！");
			//int time = (int) (Math.random() * 1000);
			int time = 3000;
			Thread.sleep(time);
			System.out.println("线程休息了："+time+"ms");
			System.out.println("线程" + Thread.currentThread().getName()
					+ "结束运行！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
