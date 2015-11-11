package com.zghw.concurrent.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPiped {

	public static void main(String[] args) {
		try {
			ReadData read = new ReadData();
			WriteData write = new WriteData();
			
			PipedOutputStream out=new PipedOutputStream();
			PipedInputStream input = new PipedInputStream();
			input.connect(out);
			//out.connect(input);
			ReadThread rt =new ReadThread(read,input);
			WriteThread wt = new WriteThread(write,out);
			new Thread(rt).start();
			Thread.sleep(1000);
			new Thread(wt).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
