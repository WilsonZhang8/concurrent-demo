package com.zghw.concurrent.core;

public class ThreadInterrupt extends Thread {
	// interrupt()僅僅是當前線程中打了一個停止的標記，並不是真的停止線程
	// this.interrupted();測試當前線程是否已經中斷
	// this.isInterrupted()測試線程是否已經中段
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 10000; i++) {
				if (this.isInterrupted()) {
					System.out.println("已經是停止狀態了！我要退出了！");
					//或者使用return 
					//建议使用抛异常的方法来实现线程的停止，因为在catch块中还可以将异常向上抛，使线程停止的时间得以传播
					throw new InterruptedException();
				}
				System.out.print("i=" + (i + 1));
				System.out.print(",");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		ThreadInterrupt ti = new ThreadInterrupt();
		ti.start();
		try {
			Thread.sleep(10);
			ti.interrupt();
			// this.interrupt()測試當前線程是否已經是中斷狀態，執行後具有將狀態標記清除為false的功能
			// System.out.println("Is it have stop1 ?="+ti.interrupted());
			// System.out.println("Is it have stop2 ?="+ti.interrupted());
			// 測試線程Thread對象是否已經是中斷狀態，但不清除狀態標誌
			System.out.println("Is it have stop1 ?=" + ti.isInterrupted());
			System.out.println("Is it have stop2 ?=" + ti.isInterrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
