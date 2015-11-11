package com.zghw.concurrent.piped;

import java.io.PipedOutputStream;

public class WriteThread implements Runnable {
	private WriteData write;
	private PipedOutputStream output;

	public WriteThread(WriteData write,PipedOutputStream output){
		this.write = write;
		this.output = output;
	}
	
	@Override
	public void run() {
		write.write(output);
	}

}
