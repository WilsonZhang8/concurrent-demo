package com.zghw.concurrent.notify;

public class ConsumerService {
	private MyStack stack;
	public ConsumerService(MyStack stack){
		super();
		this.stack = stack;
	}
	
	public void pop(){
		stack.pop();
	}
}
