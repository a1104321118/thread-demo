package com.hr.timer.timer1;

import com.hr.timer.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main2 {

    private static Timer timer = new Timer();//不能以守护线程的方式启动，否则会直接推出？？？

    public static class MyTask extends TimerTask {

        private String taskName;

        public MyTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println(taskName + " run at " + DateUtil.dateToString(new Date()));

            try {
                Thread.sleep(10000);//模拟需要 10S 时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task1 = new MyTask("task1");
        MyTask task2 = new MyTask("task2");

        String runDateStr1 = "2017-06-08 10:30:00";
        Date runDate1 = DateUtil.stringToDate(runDateStr1);
        System.out.println("task1 will run at " + runDateStr1);

        String runDateStr2 = "2017-06-08 10:30:05";
        Date runDate2 = DateUtil.stringToDate(runDateStr2);
        System.out.println("task2 will run at " + runDateStr2);

        System.out.println("now is " + DateUtil.dateToString(new Date()));
        timer.schedule(task1, runDate1);
        //虽然第二个任务计划比第一个任务晚5s，但是由于任务1耗时超过5s，所以第二个任务就被延时了
        timer.schedule(task2, runDate2);
    }
}
