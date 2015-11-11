package com.zghw.concurrent.single;

public class SingleStaticBlock {
	private static SingleStaticBlock single=null;
	private SingleStaticBlock(){}
	static {
		single = new SingleStaticBlock();
	}
	public static SingleStaticBlock getInstance(){
		return single;
	}
	public static void main(String args[]){
		Runnable r=new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println(SingleStatic.getInstance().hashCode());	
				}
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
