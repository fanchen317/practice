package com.fc.thread;

/**
 * @Author fanchen
 * @Date 2022/3/28 16:29
 */
public class CreateThreadDemo4_Task implements Runnable{
    @Override
    public void run() {
        // 每隔1s中输出一次当前线程的名字
        while (true) {
            // 输出线程的名字，与主线程名称相区分
            printThreadInfo();
            try {
                // 线程休眠一秒
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * 输出当前线程的信息
     */
    private static void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}
