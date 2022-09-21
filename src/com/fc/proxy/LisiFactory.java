package com.fc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author fanchen
 * @Date 2022/9/15 14:43
 */
public class LisiFactory implements InvocationHandler {
    // 被代理的对象
    private Object factory ;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        frontService();
        Object proxyObj = method.invoke(factory, args);
        endService();
        return null;
    }

    private void frontService() {
        System.out.println("根据您的需求进行市场调研");
    }

    private void endService() {
        System.out.println("为您提供一条龙的包办服务");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), this);
    }
}
