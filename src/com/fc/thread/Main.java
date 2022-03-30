package com.fc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author fanchen
 * @Date 2022/3/28 11:44
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //继承Thread类实现多线程
        //run()为线程类的核心方法，相当于主线程的main方法，是每个线程的入口
        //    a.一个线程调用 两次start()方法将会抛出线程状态异常，也就是的start()只可以被调用一次
        //    b.native生明的方法只有方法名，没有方法体。是本地方法，不是抽象方法，而是调用c语言方法
        //      registerNative()方法包含了所有与线程相关的操作系统方法
        //    c. run()方法是由jvm创建完本地操作系统级线程后回调的方法，不可以手动调用（否则就是普通方法）
        MyTread thread = new MyTread();
        thread.start();

        //覆写Runnable()接口实现多线程，而后同样覆写run().推荐此方式
        //    a.覆写Runnable接口实现多线程可以避免单继承局限
        //    b.当子类实现Runnable接口，此时子类和Thread的代理模式（子类负责真是业务的操作，thread负责资源调度与线程创建辅助真实业务
        MyThread1 myThread1 = new MyThread1();
        myThread1.run();


        //覆写Callable接口实现多线程（JDK1.5）
        //    a.核心方法叫call()方法，有返回值
        //    b.有返回值
        Callable<String> callable = new MyThread2();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        System.out.println(futureTask.get());


        //FixThreadPool(int n); 固定大小的线程池
        // 使用于为了满足资源管理需求而需要限制当前线程数量的场合。使用于负载比较重的服务器。
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + " " + j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        }
        ex.shutdown();


        //SingleThreadPoolExecutor :单线程池
        //需要保证顺序执行各个任务的场景
        ExecutorService ex1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            ex1.submit(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + " " + j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        }
        ex1.shutdown();

        //CashedThreadPool(); 缓存线程池
        //当提交任务速度高于线程池中任务处理速度时，缓存线程池会不断的创建线程
        // 适用于提交短期的异步小程序，以及负载较轻的服务器
        ExecutorService ex2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            ex2.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + " " + j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        }
        ex2.shutdown();
    }


}
