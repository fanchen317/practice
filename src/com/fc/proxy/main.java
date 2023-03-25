package com.fc.proxy;

/**
 * @Author fanchen
 * @Date 2022/9/15 14:38
 */
public class main {
    public static void main(String[] args) {
        //静态代理
        ClothesFactory clothesFactory = new ClothesFactory();
//        Proxy proxy = new Proxy(clothesFactory);
//        proxy.clothes("xxl");

        //jdk动态代理
        ShootFactory shootFactory = new ShootFactory();
        LisiFactory lisiFactory = new LisiFactory();
        lisiFactory.setFactory(shootFactory);
        ByShoot byShoot = (ByShoot) lisiFactory.getProxyInstance();
        byShoot.byShoot("45");
        lisiFactory.setFactory(clothesFactory);
        ByClothes byClothes = (ByClothes) lisiFactory.getProxyInstance();
        byClothes.clothes("xxl");

    }

}
