package com.hr.singlton;

/**
 * 单例模式2 使用静态块
 *
 * Created by Administrator on 2017/6/8 0008.
 */
public class MyObj2 {

    private static MyObj2 myObj2;

    static{
        myObj2 = new MyObj2();
    }

    private MyObj2(){}

    public MyObj2 getInstance(){
        return myObj2;
    }
}
