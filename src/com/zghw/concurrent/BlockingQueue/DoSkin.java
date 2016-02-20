package com.zghw.concurrent.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 做面皮用来包饺子
 * @author zghw
 *
 */
public class DoSkin implements Runnable{
	private final BlockingQueue<Skin> skinQueue;
	private static AtomicInteger id=new AtomicInteger();
	private boolean isShutdown;
	public DoSkin(BlockingQueue<Skin> skinQueue ){
		this.skinQueue=skinQueue;
		isShutdown = false;
	}
	public void stop() {
		synchronized (this) {
			isShutdown = true;
		}
	}
	@Override
	public void run() {
		while(true){
			synchronized (this) {
				if (isShutdown) {
					break;
				}
			}
			id.getAndIncrement();
			double thick =((int)(Math.random()*1000))+0.99;
			Skin sk=new Skin(id,thick);
			System.out.println("做 "+sk);
			/*try {
				Thread.sleep((int)(Math.random()*1000)+1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			skinQueue.offer(sk);
		}
	}
	
}
