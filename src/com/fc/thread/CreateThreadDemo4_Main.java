package com.fc.thread;

/**
 * @Author fanchen
 * @Date 2022/3/28 16:34
 */
public class CreateThreadDemo4_Main {
    public static void main(String[] args) throws Exception {
        // 实例化线程任务类
        CreateThreadDemo4_Task task = new CreateThreadDemo4_Task();

        // 创建线程对象,并将线程任务类作为构造方法参数传入
        new Thread(task).start();

        //主线程的任务, 为了演示多个线程一起执行
        while (true) {
            printThreadInfo();
            Thread.sleep(1000);
        }
    }

    /**
     * 输出当前线程的信息
     */
    private static void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
    }
}

