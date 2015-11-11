package com.zghw.concurrent.join;

public class Run {

	public static void main(String[] args) {
		ThreadB tb =new ThreadB();
		ThreadC tc = new ThreadC(tb);
		tb.start();
		tc.start();
	}

}
