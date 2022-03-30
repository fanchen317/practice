package com.fc.thread;

/**
 * @Author fanchen
 * @Date 2022/3/28 11:46
 */
public class MyTread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }
}
