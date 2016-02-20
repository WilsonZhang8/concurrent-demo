package com.zghw.concurrent.BlockingQueue;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 饺子皮对象
 * @author zghw
 *
 */
public class Skin {
	//序号
	private int num;
	//面皮厚度
	private double thick;

	public Skin(AtomicInteger id, double thick) {
		this.num = id.get();
		this.thick=thick;
	}

	public double getThick() {
		return thick;
	}

	public void setThick(double thick) {
		this.thick = thick;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String toString(){
		return "面皮"+num+" 厚度为："+thick+"mm";
	}
}
