package com.hr.threadlocal;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class T1 extends Thread{

    @Override
    public void run(){
        Tools.threadLocal.set("T1");
        System.out.println(Tools.threadLocal.get());
    }
}
