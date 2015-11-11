package com.zghw.concurrent.threadlocal;

public class Run {
	/**
	 * 类ThreadLocal	解决的是变量在不同线程间的隔离性
	 * 也就是不同线程间拥有自己的值，不同线程中的值是可以放入ThreadLocal类中进行保存的
	 */
	private static ThreadLocal tl =new ThreadLocal();
	public static void main(String[] args) {
		if(tl.get()==null){
			System.out.println("线程变量中没有值");
			tl.set("设置main线程中的变量值");
		}
		System.out.println(tl.get());
	}

}
