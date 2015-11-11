package com.zghw.concurrent.notify;

public class ProductThread extends Thread {
	private ProductService ps;
	public ProductThread(ProductService ps){
		super();
		this.ps = ps;
	}
	
	@Override
	public void run(){
		while(true){
			ps.push();
		}
	}
}
