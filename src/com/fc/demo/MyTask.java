package com.fc.demo;

import java.util.concurrent.Callable;

/**
 * @Author fanchen
 * @Date 2022/8/31 15:00
 */
public class MyTask implements Callable<Integer> {
    private int upperBounds;

    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}
