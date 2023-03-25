package com.fc.proxy;

/**
 * @Author fanchen
 * @Date 2022/9/15 14:42
 */
public class ShootFactory implements ByShoot{
    @Override
    public void byShoot(String size) {
        System.out.println("已经为您生产出了尺码为"+size+"的鞋子");
    }
}
