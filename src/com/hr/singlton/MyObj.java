package com.hr.singlton;

/**
 * //单例模式 在多线程情况下的正确写法
 *
 * Created by Administrator on 2017/6/8 0008.
 */
public class MyObj {

    private static MyObj object;

    private MyObj(){} //写成 private 让该类不能 new 出来

    public static MyObj getInstance(){
        if(null != object){
            try {
                Thread.sleep(1000);//模拟并发情况
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MyObj.class){
                if(null != object){
                   object = new MyObj();
                }
           }
        }

        return object;
    }

    //上面采用了 DCL 双检查 锁机制保证的，判断了两次null
    //在同步块中是为了保证单例，在外面是为了提高效率
}
