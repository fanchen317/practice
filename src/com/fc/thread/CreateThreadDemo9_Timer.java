package com.fc.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author fanchen
 * @Date 2022/3/28 16:55
 */
public class CreateThreadDemo9_Timer {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        //创建定时器
        Timer timer = new Timer();

        //提交计划任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行了...");
            }
        }, new Date(), 1000);
    }
}
