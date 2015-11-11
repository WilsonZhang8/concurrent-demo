package com.zghw.concurrent;

public class MoreBasicThread {
	public static void main(String args[]){
		for(int i=0;i<5;i++){
			Thread thread =new Thread(new LiffOff());
			thread.start();
		}
		System.out.println("Wait for liffOff!");
	}
}
