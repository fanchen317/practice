package com.fc;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 递归7道题练习
 */
public class TestRecu {
    //1.递归求 N 的阶乘
    public static int mul(int n){
        if(n == 1){
            return 1;
        }
        return n * mul(n - 1);
    }

    //2.递归求 1 + 2 + 3 + ... + 10
    public static int sum(int n){
        if(n == 0){
            return 0;
        }
        return n + sum(n - 1);
    }

    //3.按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
    public static void print(int n){
        if (n > 9){
            print(n / 10);
        }
        System.out.print(n % 10 + " ");

    }

    //4.写一个递归方法，输入一个非负整数，返回组成它的数字之和.
    public static int sum1(int n){
        if (n < 10) {
            return n;
        }
        return sum1(n / 10) + (n % 10);
    }

    //5.求斐波那契数列的第n项
    //0、1、1、2、3、5、8、13、21、34、…
    public static int sum2(int n){
        if (n < 3){
            if(n == 0){
                return 0;
            }else{
                return 1;
            }
        }else {
            return sum2(n - 1) + sum2(n - 2);
        }
    }


    //6.递归求解汉诺塔问题
    //汉诺塔问题是一个经典的问题。汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。
    //大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
    //大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
    //并且规定，任何时候，在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。 问应该如何操作？
    public static void hanoiTower(int n, String x, String y, String z){
        if (n == 1) {
            System.out.println(x + "-->" + z);
        } else {
            hanoiTower(n - 1, x, z, y);
            System.out.println(x + "-->" + z);
            hanoiTower(n - 1, y, x, z);
        }
    }


    //7.递归实现代码: 青蛙跳台阶问题
    //一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法
    public static int jumpFloor(int n){
        if (n == 1 || n == 2){
            return n;
        }
        return jumpFloor(n - 1) + jumpFloor(n - 2);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //第一题
//        System.out.println("请输入N");
//        int n = input.nextInt();
//        System.out.println(mul(n));

        //第二题
//        System.out.println("请输入N");
//        int n = input.nextInt();
//        System.out.println(sum(n));

        //第三题
//        System.out.println("请输入N");
//        int n = input.nextInt();
//        print(n);

        //第四题
//        System.out.println("请输入N");
//        int n = input.nextInt();
//        System.out.println(sum1(n));

        //第五题
//        System.out.println("请输入N");
//        int n = input.nextInt();
//        System.out.println(sum2(n));

        //第六题
        hanoiTower(3, "x", "y", "z");

        //第七题
//        System.out.println("请输入N");
//        int n = input.nextInt();
//        System.out.println(jumpFloor(n));


    }
}
