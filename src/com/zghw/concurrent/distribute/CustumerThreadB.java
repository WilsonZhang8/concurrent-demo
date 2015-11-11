package com.zghw.concurrent.distribute;

public class CustumerThreadB extends Thread {
	private Product product;
	public CustumerThreadB(Product product){
		super();
		this.product = product;
	}
	@Override
	public void run(){
			product.custumerB();
	}
}
