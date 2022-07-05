package com.fc.sync;

/**
 * @Author fanchen
 * @Date 2022/6/7 10:55
 */
public class sisuo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取线程名称
                String threadName = Thread.currentThread().getName();
                //1.获取资源1
                synchronized (lock1) {
                    System.out.println(threadName + " 获取到了lock1");
                    try {
                        //2.等待1ms,让线程t1和线程t2都获取到相应的资源
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + " waiting lock2");
                    //3.获取资源2
                    synchronized (lock2) {
                        System.out.println(threadName + "获取到了lock2");
                    }
                }
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取线程名称
                String threadName = Thread.currentThread().getName();
                //1.获取资源1
                synchronized (lock2) {
                    System.out.println(threadName + " 获取到了lock2");
                    try {
                        //2.等待1ms,让线程t1和线程t2都获取到相应的资源
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + " waiting lock1");
                    //3.获取资源2
                    synchronized (lock1) {
                        System.out.println(threadName + "获取到了lock1");
                    }
                }
            }
        }, "t2");
        t2.start();

    }
}
