package com.zghw.concurrent.single;

import java.io.Serializable;

public class SingleStatic implements Serializable{
	private static final long serialVersionUID = 7974531820274968273L;
	private static class innerSingle{
		private static final SingleStatic single = new SingleStatic();
	}
	private SingleStatic (){}
	public static SingleStatic getInstance(){
		return innerSingle.single;
	}
	
	protected Object reeadResolve(){
		return innerSingle.single;
	}
	
	public static void main(String args[]){
		Runnable r=new Runnable(){

			@Override
			public void run() {
				System.out.println(SingleStatic.getInstance().hashCode());
			}
			
		};
		
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		Thread t3=new Thread(r);
		t1.start();
		t2.start();
		t3.start();
	}
}
