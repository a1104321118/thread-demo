package com.hr.timer.timer1;

import com.hr.timer.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main {

    private static Timer timer = new Timer(true);//这样是以守护线程的方式进行启动的
    //private static Timer timer = new Timer();//这样是以 非守护线程的方式进行启动的（线程不会自动退出）

    public static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("task run at " + DateUtil.dateToString(new Date()));
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task = new MyTask();
        String runDateStr = "2017-06-08 10:10:00";
        Date runDate = DateUtil.stringToDate(runDateStr);
        System.out.println("now is " + DateUtil.dateToString(new Date()));
        System.out.println("task will run at " + runDateStr);
        timer.schedule(task, runDate);
    }

    //如果执行计划比 当前时间要早，那么会立即执行
}
