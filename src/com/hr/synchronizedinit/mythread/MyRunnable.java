package com.hr.synchronizedinit.mythread;
/**
 * @author hr
 * @date 2017年4月18日
 */
public class MyRunnable implements Runnable{

	private Method m;
	
	public Method getM() {
		return m;
	}

	public void setM(Method m) {
		this.m = m;
	}

	@Override
	public void run() {
		//m.method();
		//m.method2();
		m.method3();
	}

}
