package com.hr.timer.timer3;

import com.hr.timer.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main {

    private static Timer timer = new Timer();

    public static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("task run at " + DateUtil.dateToString(new Date()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task = new MyTask();
        String runDateStr = "2017-06-08 10:10:00";
        Date runDate = DateUtil.stringToDate(runDateStr);
        System.out.println("now is " + DateUtil.dateToString(new Date()));
        System.out.println("task will run at " + runDateStr);
        //timer.schedule(task, 1000L); // 延时 1S 执行

        //timer.schedule(task, new Date(),2000L); // 从上一次任务 开始 往后计算2S，如果任务延时的话，下次任务立即执行
        timer.scheduleAtFixedRate(task, new Date(),2000L); // 从上一次任务 结束 往后计算2S， 如果延时的话，下次任务立即执行

    }

}
