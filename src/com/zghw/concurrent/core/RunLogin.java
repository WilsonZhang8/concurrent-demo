package com.zghw.concurrent.core;

public class RunLogin {

	public static void main(String[] args) {
		ALogin a =new ALogin();
		a.start();
		BLogin b = new BLogin();
		b.start();

	}

}
