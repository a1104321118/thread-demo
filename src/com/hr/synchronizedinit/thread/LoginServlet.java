package com.hr.synchronizedinit.thread;
/**
 * @author hr
 * @date 2017年4月12日
 */
public class LoginServlet {

	private static String usernameRef;
	private static String passwordRef;
	
	synchronized public static void doPost(String username, String password) throws InterruptedException{
		System.out.println(username + ":进入该方法");
		usernameRef = username;
		if(usernameRef.equals("a")){
			Thread.sleep(5000);//当前线程停止，不是主线程
		}
		passwordRef = password;
		System.out.println("usernameRef:" + usernameRef + ";passwordRef:" + passwordRef);
	}
	
	public static void main(String[] args) throws InterruptedException {
		//System.out.println("线程不安全");
		System.out.println("线程安全");
		ALogin a = new ALogin();
		a.start();
		Thread.sleep(200);//确保a比b先执行
		BLogin b = new BLogin();//b线程已经启动，只是在等A线程释放锁
		b.start();
	}
}

class ALogin extends Thread{
	@Override
	public void run(){
		try {
			System.out.println("a线程已经启动");
			LoginServlet.doPost("a", "aa");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BLogin extends Thread{
	@Override
	public void run(){
		try {
			System.out.println("b线程已经启动");
			LoginServlet.doPost("b", "bb");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
