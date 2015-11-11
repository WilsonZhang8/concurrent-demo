package com.zghw.concurrent.notify;

public class ProductService {
	private MyStack stack;
	public ProductService(MyStack stack){
		super();
		this.stack=stack;
	}
	public void push(){
		stack.push();
	}
}
