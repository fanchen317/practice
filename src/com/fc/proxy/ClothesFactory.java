package com.fc.proxy;

/**
 * @Author fanchen
 * @Date 2022/9/15 14:38
 */
public class ClothesFactory implements ByClothes{
    @Override
    public void clothes(String size) {
        System.out.println("已经为您制作好了一整套size为"+size+"的衣服。。。。。。。。");
    }
}
