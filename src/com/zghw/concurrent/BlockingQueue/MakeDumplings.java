package com.zghw.concurrent.BlockingQueue;

import java.util.concurrent.*;

public class MakeDumplings {

	public static void main(String[] args) {
		BlockingQueue<Skin> queue = new ArrayBlockingQueue<Skin>(100);
		ExecutorService exc = Executors.newFixedThreadPool(20);
		MakeDumpling md=new MakeDumpling(queue);
		DoSkin ds=new DoSkin(queue);
		md.start();
		exc.execute(ds);
		try {
			Thread.sleep(10000);
			ds.stop();
			md.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
