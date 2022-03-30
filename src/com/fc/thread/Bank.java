package com.fc.thread;

/**
 * @Author fanchen
 * @Date 2022/3/28 11:40
 */
public class Bank implements Runnable {
    int money; //定义变量

    public void setMoney(int n) {
        money = n; //设置初始值
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("会计")) {
            saveOrTake(300);
        } else if (Thread.currentThread().getName().equals("出纳")) {
            saveOrTake(150);

        }
    }

    public synchronized void saveOrTake(int m) { //做个修饰
        if (Thread.currentThread().getName().equals("会计")) {
            for (int i = 0; i < 3; i++) { //分三次存
                money = money + m / 3;
                System.out.println(Thread.currentThread().getName() + "存入" + m / 3 + ",账上还有" + money + ",休息一会儿再存"); //打印每次存的数量
                try {
                    Thread.sleep(1000); //休息1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Thread.currentThread().getName().equals("出纳")) {
            for (int i = 0; i < 3; i++) {
                money = money - m / 3;
                System.out.println(Thread.currentThread().getName() + "取出" + m / 3 + ",账上还有" + money + ",休息一会儿再取");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }

        }

    }

}

