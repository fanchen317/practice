package com.fc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author fanchen
 * @Date 2022/3/28 17:06
 */
public class CreateThreadDemo12_ThreadPool {
    public static void main(String[] args) {
        //创建固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            //提交多个线程任务,并执行
            threadPool.submit(() -> {
                printThreadInfo();
            });
        }
    }

    /**
     * 输出当前线程的信息
     */
    private static void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
