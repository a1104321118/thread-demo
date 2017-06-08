package com.hr.threadlocal;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class T2 extends Thread{

    @Override
    public void run(){
        Tools.threadLocal.set("T2");
        System.out.println(Tools.threadLocal.get());
    }
}
