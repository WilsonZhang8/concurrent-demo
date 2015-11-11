package com.zghw.concurrent.core;

public class LoginServlet {
	private static String usernameRef;
	private static String passwordRef;
	
	synchronized public static void doPost(String username,String password){
		usernameRef=username;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passwordRef= password;
		System.out.println("usernameRef="+usernameRef+"  passwordRef="+passwordRef);
		
	}
}
