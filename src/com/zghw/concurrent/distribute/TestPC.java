package com.zghw.concurrent.distribute;

public class TestPC {
	public static void main(String args[]){
		Product product =new Product();
		for(int i=0;i<1000000;i++){
			CustumerThreadA cta =new CustumerThreadA(product);
			CustumerThreadB ctb =new CustumerThreadB(product);
			cta.start();
			ctb.start();
		}
	}
}
