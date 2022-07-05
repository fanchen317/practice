package com.fc.thread;

import java.util.concurrent.*;

/**
 * @Author fanchen
 * @Date 2022/6/13 11:24
 */
public class CallableDemo {
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        //方式1
        MyTask myTask = new MyTask();
        FutureTask<Integer> futureTask = new FutureTask<>(myTask);
        pool.submit(futureTask);

        //方式二
        //new Thread(futureTask).start();

//        try {
//            //拿结果方式一
//            Integer res3ult = futureTask.get();
//
//            //拿结果方式二, 设置超时时间, 最多等5秒
//            Integer result1 = futureTask.get(5, TimeUnit.SECONDS);
//            System.out.println(result);
//            System.out.println(result1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        TimeUnit.SECONDS.sleep(5);
        return sum;
    }
}
