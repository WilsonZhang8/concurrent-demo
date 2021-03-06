package com.zghw.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			es.execute(new LiffOff());
		}
		es.shutdown();
		System.out.println("Wait for liffOff!");
	}

}
