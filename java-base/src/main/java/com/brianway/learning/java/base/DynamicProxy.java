/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 */
package com.brianway.learning.java.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *
 * @author xus
 * @since 2018-03-05 17:00
 *
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(target, args);
        System.out.println("after");
        return res;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
