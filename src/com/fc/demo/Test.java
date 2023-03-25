package com.fc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author fanchen
 * @Date 2022/8/31 14:51
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        Account account = new Account();
//        ExecutorService service = Executors.newFixedThreadPool(100);
//        for (int i = 1; i <= 100; i++) {
//            service.execute(new AddMoneyThread(account, 1));
//        }
//        service.shutdown();
//        while (!service.isTerminated()) {
//        }
//        System.out.println("账户余额: " + account.getBalance());

        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new MyTask((int) (Math.random() * 100))));
        }

        int sum = 0;
        for(Future<Integer> future : list) {
// while(!future.isDone()) ;
            sum += future.get();
        }
        System.out.println(sum);
    }
}
