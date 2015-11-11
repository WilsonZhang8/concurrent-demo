package com.zghw.concurrent.join;

public class ThreadA extends Thread{

	@Override
	public void run(){
		for(int i=0;i<10;i++){
			String str =new String();
			Math.random();
			System.out.println(str+" "+i);
		}
	}
}
