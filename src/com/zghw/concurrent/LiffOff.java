package com.zghw.concurrent;

public class LiffOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiffOff(){}
	public LiffOff(int countDown){
		this.countDown = countDown;
	}
	
	public String status(){
		return "#id("+id+")"+(countDown>0?countDown:"liffOff!");
	}
	
	@Override
	public void run() {
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
		
	}

}
