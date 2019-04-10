package com.dnight.framework.aopdemo;

import java.lang.reflect.Proxy;

/**
 * @author ZHONGPENG769
 * @date 2019/3/19
 */
public class SimpleAOP {

    public static Object getProxy(Object bean, Advice advice){
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(),advice);
    }
}
