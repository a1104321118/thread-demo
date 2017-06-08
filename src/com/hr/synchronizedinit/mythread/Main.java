package com.hr.synchronizedinit.mythread;
/**
 * @author hr
 * @date 2017年4月18日
 */
public class Main {

	/**
	 * 简而言之，synchornized 是根据对象进行判断的，
	 * 当目前锁的是同一个对象的时候，能保证一次进入一个线程
	 * 当目前锁的不是同一个对象的时候，则达不到多线程的需求
	 * @param args
	 */
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		mr.setM(new Method());
		Thread t1 = new Thread(mr, "lockthis");
		Thread t2 = new Thread(mr, "t2");
		t1.start();
		t2.start();
	}
}
