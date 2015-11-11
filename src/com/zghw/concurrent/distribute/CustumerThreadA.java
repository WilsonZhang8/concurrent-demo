package com.zghw.concurrent.distribute;

public class CustumerThreadA extends Thread {
	private Product product;
	public CustumerThreadA(Product product){
		super();
		this.product = product;
	}
	@Override
	public void run(){
		product.custumerA();
	}
}
