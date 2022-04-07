package com.fc.java8.lambda;

/**
 * @Author fanchen
 * @Date 2022/4/1 15:02
 */
public class Demo {
    public static void main(String[] args) {
        //1.创建一个新的线程,执行线程要执行的任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中执行的代码: " + Thread.currentThread().getName());
            }
        }).start();
        System.out.println("主线程中的代码: " + Thread.currentThread().getName());
        //代码分析:
        //1.Thread类需要一个Runnable接口作为参数,其中的抽象方法run方法是用来指定线程任务内容的核心
        //2.为了指定run方法体,不得不不需要Runnable的实现类
        //3.为了省去定义一个Runnable的实现类,不得不使用匿名内部类
        //4.必须覆盖重写抽象run方法,所有的方法名称,方法参数,方法返回值不的不都重写一遍,而且不能出错
        //5.而实际上,我们只在乎方法体重的代码
        System.out.println("---------------");

        //lambda表达式是一个匿名函数, 可以理解为一段可以传递的代码
        new Thread(() -> {
            System.out.println("新线程Lambda表达式... " + Thread.currentThread().getName());
        }).start();


    }

}
