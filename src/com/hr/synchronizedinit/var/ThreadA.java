package com.hr.synchronizedinit.var;

/**
 * @author hr
 * @date 2017年4月19日
 */
public class ThreadA extends Thread {

	private Var var;

	public ThreadA(Var var) {
		super();
		this.var = var;
	}

	@Override
	public void run() {
		var.method("a");

	}
}
