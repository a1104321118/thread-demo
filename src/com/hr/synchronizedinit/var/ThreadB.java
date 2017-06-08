package com.hr.synchronizedinit.var;
/**
 * @author hr
 * @date 2017年4月19日
 */
public class ThreadB extends Thread{

	private Var var;

	public ThreadB(Var var) {
		super();
		this.var = var;
	}

	@Override
	public void run() {
		var.method("b");

	}
}
