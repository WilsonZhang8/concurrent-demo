package com.zghw.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * 使用面皮包饺子
 * 
 * @author zghw
 *
 */
public class MakeDumpling {
	private final BlockingQueue<Skin> skinQueue;
	private final MakeThread makeThread;
	private boolean isShutdown;

	public MakeDumpling(BlockingQueue<Skin> skinQueue) {
		this.skinQueue = skinQueue;
		makeThread = new MakeThread();
		isShutdown = false;
	}

	public void start() {
		makeThread.start();
	}

	public void stop() {
		synchronized (this) {
			isShutdown = true;
		}
		makeThread.interrupt();
	}

	private class MakeThread extends Thread {
		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					if (isShutdown) {
						break;
					}
				}
				Skin skin = skinQueue.poll();
				if (skin != null) {
					/*try {
						// Thread.sleep((int) (Math.random() * 1000) + 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					System.out.println("使用 " + skin + " ,包饺子");
				}
			}
		}

	}

}
