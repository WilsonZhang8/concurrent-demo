package com.zghw.concurrent.piped;

import java.io.PipedInputStream;

public class ReadThread implements Runnable {
	private ReadData read;
	private PipedInputStream input;
	public ReadThread(ReadData read,PipedInputStream input){
		this.read = read;
		this.input = input;
	}
	@Override
	public void run() {
		read.read(input);
	}

}
