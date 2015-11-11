package com.zghw.concurrent.core;

public class BLogin extends Thread {
	@Override
	public void run(){
		LoginServlet.doPost("b", "bb");
	}
}
