package com.fc.thread;

import java.util.concurrent.Callable;

/**
 * @Author fanchen
 * @Date 2022/3/28 11:54
 */
public class MyThread2 implements Callable<String> {
    private int count = 10;

    @Override
    public String call() throws Exception {
        for (int i = count; i > 0; i--) {
			Thread.yield();
            System.out.println(Thread.currentThread().getName() + "当前票数：" + i);
        }

        return "sale out";
    }
}
