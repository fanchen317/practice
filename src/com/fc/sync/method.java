package com.fc.sync;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author fanchen
 * @Date 2022/6/7 11:12
 */
public class method {
    private static Boolean flag = false;//手动设置的标志位flag

    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            while (!flag) {
//                //flag为真时停止循环
//                System.out.println("myThread");
//                try {
//                    Thread.sleep(1000);//打印一次阻塞一次
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        flag = true;

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //通过isInterred()判断标志位是否为true,为true说明线程要退出
//                while (!Thread.currentThread().isInterrupted()) {
//                    System.out.println("my Thread");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println("完善");
//                        break;
//                    }
//                }
//            }
//        });
//
//        t.start();//创建新的线程
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t.interrupt();
//        //t线程运行3秒后,通过interrupt()方法将标志位设置为true

        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("my Thread~~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join();
        for (int i = 0; i < 3; i++) {
            System.out.println("my main!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        Set<String> hashSet = new HashSet<String>();
        Set<String> linkedHashSet = new LinkedHashSet<String>();
        Set<String> treeSet = new TreeSet<String>();
        Vector<String> vector = new Vector<String>();
        Stack<String> stack = new Stack<String>();//过时
        Queue<String> queue = new LinkedList<String>();
        Deque<String> deque = new ArrayDeque<String>();//取代stack
        Map<String, String> hashMap = new HashMap<String, String>();
        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        Map<String, String> treeMap = new TreeMap<String, String>();
        Map<String, String> hashTable = new Hashtable<String, String>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
    }
}
