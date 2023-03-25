package com.fc;

import java.util.Random;

/**
 * @Author：fanchen
 * @Date：2023/1/10 14:10
 */
public class RandomDemo {
    public static void main(String[] args) {

        Random rd = new Random();

        int size = 8; // 0,1,2,3,4,5,6
        /**
         * 分析：
         * 1    2    3    4    5    6    7    8    9    10
         * 2    4    6    8    10
         * 1    3    5    7    9
         */


//        for (int i = 0; i < 10; i++) {
//            int odd = (rd.nextInt(size) * 2 + 1) % (size % 2 == 0 ? size : size - 1);
//            System.out.println("随机生成奇数：" + odd);
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < 10; i++) {
//            int even = ((rd.nextInt(size) + 1) * 2) % (size % 2 == 0 ? size : size - 1);
//            System.out.println("随机生成偶数：" + even);
//
//        }
        for (int i = 0; i < 20; i++) {
//            if (size % 2 == 0) {
//                int odd = rd.nextInt(size) * 2 + 1;
//                System.out.println("随机生成奇数：" + odd);
//            } else {
//                int odd = rd.nextInt(size) * 2 + 1;
//                System.out.println("随机生成奇数：" + odd);
//            }

            int odd = (rd.nextInt(size) * 2 + 1 ) % (size % 2 == 0 ? size : size - 1);
            System.out.println("随机生成奇数：" + odd);

        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            int even = ((rd.nextInt(size) + 1) * 2 ) % (size % 2 == 0 ? size : size + 1);
            System.out.println("随机生成偶数：" + even);
        }


    }
}
