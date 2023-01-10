package com.fc;

import java.util.Random;

/**
 * @Author：fanchen
 * @Date：2023/1/10 14:10
 */
public class RandomDemo {
    public static void main(String[] args) {

        Random rd = new Random();

        /**
         * 分析：
         * 1    2    3    4    5    6    7    8    9    10
         * 2    4    6    8    10
         * 1    3    5    7    9
         */

        for (int i = 0; i < 10; i++) {
            int odd = rd.nextInt(1) * 2 + 1;
            System.out.println("随机生成奇数：" + odd);
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            int even = (rd.nextInt(1) + 1) * 2;
            System.out.println("随机生成偶数：" + even);
        }

    }
}
