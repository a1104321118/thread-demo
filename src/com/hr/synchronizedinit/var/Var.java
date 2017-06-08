package com.hr.synchronizedinit.var;
/**
 * @author hr
 * @date 2017年4月19日
 */
public class Var {

	private int num = 0;
	
	public void method(String username){
		int num2 = 0;
		if(username.equals("a")){
			num = 100;
			num2 = 100;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			num = 200;
			num2 = 200;
		}
		System.out.println("username:" + username + ";num:" +num + ";num2:" + num2);
	}
	

}
