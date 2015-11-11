package com.zghw.concurrent.notify;

import java.util.ArrayList;
import java.util.List;

public class MyObject {
	private List<Integer> list=new ArrayList<Integer>();
	
	public void add(Integer num){
		list.add(num);
	}
	
	public int getSize(){
		return list.size();
	}

}
