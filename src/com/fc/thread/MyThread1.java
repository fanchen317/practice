package com.fc.thread;

/**
 * @Author fanchen
 * @Date 2022/3/28 11:50
 */
public class MyThread1 implements Runnable {
    public static int count = 10;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-当前剩余票数:" + count--);
        }
    }
}
