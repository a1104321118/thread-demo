package com.hr.synchronizedinit.thread;
/**
 * @author hr
 * @date 2017年4月19日
 */
public class InterruptTest {

	public static void main(String[] args) {
		Thread1 t = new Thread1();
		
		try {
			t.start();
			Thread.sleep(100);
			t.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread1 extends Thread{
	
	@Override
	public void run(){
		
		System.out.println("进入thread");
		for(int i=0; i<50000000; i++){
			if(this.interrupted()){
				System.out.println("当前线程已经停止");
				return;
			}
			System.out.println(i);
		}
		
	}
}