package com.hr.synchronizedinit.volatile1;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Task implements Runnable{

    volatile private boolean isContinue;

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    @Override
    public void run() {
        System.out.println("run begin");
        while (isContinue){
            System.out.println(isContinue);
        }
        System.out.println("run end");
    }
}
