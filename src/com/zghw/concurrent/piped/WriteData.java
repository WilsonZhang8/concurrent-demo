package com.zghw.concurrent.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
	public void write(PipedOutputStream out) {
		System.out.println("write:   ");
		try {
			for (int i = 0; i < 300; i++) {
				String data = "" + (i+1);
				System.out.print(data);
				out.write(data.getBytes());
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
