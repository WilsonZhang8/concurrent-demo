package com.zghw.concurrent.core;

public class RunShareSynchronized {
	//共享數據的情況就是多個線程可以訪問同一個變量 產生非線程安全的問題
	//在run方法前加入synchronized關鍵字，是多個線程在執行run方法時，以排隊的方式進行處理。
	//當一個線程調用run前，縣判斷run方法有沒有被上鎖，如果上鎖，就說明有其他線程正在使用run方法，必須等待其他線程對run方法調用結束後才可以執行run方法
	//這樣就可以實現排隊調用run方法的目的，也就達到了按順序對count變量減1的效果。
	//synchronized可以在任意對象及方法上枷鎖，而枷鎖的這段代碼為“互斥區”或臨界區。
	//當一個線程想要執行同步方法裡面的代碼時，線程首先嘗試去拿這把鎖，如果能夠拿到這把鎖，那麼這個線程就可以執行synchronized裡面的代碼。
	//如果不能拿到這把鎖，那麼這個線程就會不斷地嘗試拿到這把鎖，知道能夠拿到為止，而且時多個線程同時去爭搶這把鎖。
	//"非線程安全“主要指多個線程對同一個對象中的同一個實例變量進行操作時會出現值被更改/值不同步的情況，進而影響程序的執行流程。
	public static void main(String args[]){
		MyThreadShare mythread=new MyThreadShare();
		Thread a=new Thread(mythread,"A");
		Thread b=new Thread(mythread,"B");
		Thread c=new Thread(mythread,"C");
		a.start();
		b.start();
		c.start();
	}
}
