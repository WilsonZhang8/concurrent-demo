package com.zghw.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService es=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			es.execute(new LiffOff());
		}
		es.shutdown();
		System.out.println("Wait for liffOff!");
	}
}
