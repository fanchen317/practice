package com.fc.sync;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author fanchen
 * @Date 2022/6/6 17:56
 */
public class Starter {
    public static void main(String[] args) {
        final Cabinet cabinet = new Cabinet();
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 9; i++) {
            final int storeNumber = i;
            es.execute(() -> {
                User user = new User(cabinet, storeNumber);
                synchronized (cabinet) {
                    user.useCabinet();
                    System.out.println("我是用户" + storeNumber + ",我存储的数字是：" + cabinet.getStoreNumber());
                }
            });
        }
        es.shutdown();
    }


}
