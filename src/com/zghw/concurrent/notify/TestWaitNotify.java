package com.zghw.concurrent.notify;

public class TestWaitNotify {
	public static void main(String args[]){
		MyObject obj =new MyObject();
		ThreadWait tw = new ThreadWait(obj);
		tw.start();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ThreadNotify tn = new ThreadNotify(obj);
		tn.start();
	}
}
