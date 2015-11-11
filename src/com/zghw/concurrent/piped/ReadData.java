package com.zghw.concurrent.piped;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
	public void read(PipedInputStream input){
		System.out.println("read:   ");
		try {
			byte[] byteArray=new byte[20];
			int length=input.read(byteArray);
			while(length!=-1){
				String str =new String(byteArray,0,length);
				System.out.print(str);
				length=input.read(byteArray);
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
