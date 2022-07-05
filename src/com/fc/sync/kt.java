package com.fc.sync;

/**
 * @Author fanchen
 * @Date 2022/6/6 14:57
 */
public class kt {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "syncThread1");
        Thread thread2 = new Thread(syncThread, "syncThread2");
        thread1.start();
        thread2.start();
//        System.out.println("使用关键字synchronized每次调用进行new SyncThread");
//        Thread thread1 = new Thread(new SyncThread(), "syncThread1");
//        Thread thread2 = new Thread(new SyncThread(), "syncThread2");
//        thread1.start();
//        thread2.start();
    }

}

class ClassName {
    public void method() {
        synchronized (ClassName.class) {

        }
    }
}

class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public synchronized void run() {
        method();
    }

    private static void method() {
        synchronized (SyncThread.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名:" + Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}