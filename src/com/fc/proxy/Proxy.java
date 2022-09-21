package com.fc.proxy;

/**
 * @Author fanchen
 * @Date 2022/9/15 14:38
 */
public class Proxy implements ByClothes{
    //被包含的真是对象
    public ClothesFactory factory;

    public Proxy(ClothesFactory factory) {
        // TODO Auto-generated constructor stub
        this.factory = factory;
    }

    @Override
    public void clothes(String size) {
        FrontService();
        factory.clothes(size);
        endService();

    }

    //前置服务
    public void FrontService() {
        System.out.println("根据您的需求进行市场调研");
    }

    //后置服务
    public void endService() {
        System.out.println("为您提供一条龙的包办服务");
    }

}
