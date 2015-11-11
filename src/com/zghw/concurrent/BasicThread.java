package com.zghw.concurrent;

public class BasicThread {
	public static void main(String args[]){
		Thread thread =new Thread(new LiffOff());
		thread.start();
		System.out.println("Wait for liffOff!");
	}
}
