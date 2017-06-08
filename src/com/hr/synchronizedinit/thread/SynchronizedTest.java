package com.hr.synchronizedinit.thread;
/**
 * @author hr
 * @date 2017年4月18日
 */
public class SynchronizedTest {

	public static void main(String[] args) throws InterruptedException {
		MyRunnable mr = new MyRunnable(1);
		Thread t1 = new Thread(mr,"lockthis");
		Thread t2 = new Thread(mr,"t2");
		t1.start();
		t2.start();
	}
	
	public static void test(Integer a) throws InterruptedException{
		synchronized (a){

			System.out.println(a);
			Thread.sleep(300);
			a = a + 1; //对与另外一个线程无用，因为这是方法里面的变量
		}
	}
}

class MyRunnable implements Runnable{

	int a;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public MyRunnable(int a) {
		super();
		this.a = a;
	}

	@Override
	public void run() {
		try {
			SynchronizedTest.test(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
