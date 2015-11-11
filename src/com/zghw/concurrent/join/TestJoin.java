package com.zghw.concurrent.join;

public class TestJoin {
	public static void main(String args[]){
		MyThread t=new MyThread();
		t.start();
		System.out.println("不知道线程t什么时间运行完成！");
		System.out.println("等线程t运行完后运行下面的代码");
		try {
			/**
			 * join()方法的作用是使所属的线程t正常执行方法run()完成后
			 * ，当前线程main()进行无限期的阻塞，等待线程t销毁后在继续执行线程
			 * main()后面的代码。
			 * 方法join()具有使线程排队运行的作用，有些类似同步的运行效果
			 * 2000代表了等待的时间
			 */
			t.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我可以运行了");
	}
}
