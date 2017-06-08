package com.hr.timer.timer2;

import com.hr.timer.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main {


    public static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("task run at " + DateUtil.dateToString(new Date()));
            //this.cancel(); //cancel() 把自己从任务队列中清除
        }
    }

    public static void main(String[] args) throws ParseException, InterruptedException {
        MyTask task = new MyTask();
        String runDateStr = "2017-06-08 10:39:00";
        Date runDate = DateUtil.stringToDate(runDateStr);
        System.out.println("now is " + DateUtil.dateToString(new Date()));
        Timer timer = new Timer();
        timer.schedule(task, runDate, 5000L); // 5s 执行一次 ，runDate 是第一次执行的时间
        timer.cancel();
        //将任务队列中的任务全部清除，看源码，只有当timer 抢到锁的时候，才会cancel
        //在执行的时候 schedule 会占有锁，导致 cancel 抢不到锁，就无法停止
        //但是schedule 不执行的时候就不会占有锁，就不会取消

        //这种情况可能 cancle 就争抢不到 queue 的锁
        /*while (true) {
            timer.schedule(task, runDate);
            timer.cancel();
        }*/
    }
}

