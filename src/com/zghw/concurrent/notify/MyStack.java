package com.zghw.concurrent.notify;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List list = new ArrayList();

	synchronized public void push() {
		try{
			while(list.size()==1){
				System.out.println("线程"+Thread.currentThread().getId()+"："+Thread.currentThread().getName()+" waiting!!!");
				this.wait();
			}
			System.out.println("线程"+Thread.currentThread().getId()+"："+Thread.currentThread().getName()+" running###");
			String value = "data: " + Math.random();
			list.add(value);
			this.notifyAll();
			System.out.println("list size : "+list.size() );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public void pop() {
		try {
			while (list.size() == 0) {
				System.out.println("线程"+Thread.currentThread().getId()+"："+Thread.currentThread().getName()+" waiting!!!");
				this.wait();
			}
			System.out.println("线程"+Thread.currentThread().getId()+"："+Thread.currentThread().getName()+" running###");
			list.remove(0);
			this.notifyAll();
			System.out.println("list size : "+list.size() );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
