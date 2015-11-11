package com.zghw.concurrent.single;

public class Single {
	private volatile static Single single;
	
	private Single(){}
	
	public static Single getInstance(){
		if(single==null){
			try {
				Thread.sleep(3000);
				synchronized(Single.class){
					if(single==null){
						single= new Single();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return single;
	}

	
	public static void main(String args[]){
		Runnable r=new Runnable(){

			@Override
			public void run() {
				System.out.println(Single.getInstance().hashCode());
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
