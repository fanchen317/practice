package com.fc.demo;

/**
 * 存钱线程
 *
 * @Author fanchen
 * @Date 2022/8/31 14:51
 */
public class AddMoneyThread implements Runnable{
    private Account account; // 存入账户
    private double money; // 存入金额

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
//        synchronized (account) {
            account.deposit(money);
//        }
    }
}
