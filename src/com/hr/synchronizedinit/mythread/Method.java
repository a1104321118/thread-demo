package com.hr.synchronizedinit.mythread;
/**
 * @author hr
 * @date 2017年4月18日
 */
public class Method {

	//如果不声明为 synchronized ，则线程会同时进入
	public void method(){
		System.out.println("111");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//一次进入一个线程（相当于 synchornized（this））
	synchronized public void method2(){
		System.out.println("222");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void method3(){
		System.out.println(this);
		synchronized (this) {
			System.out.println("333");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
