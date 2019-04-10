package com.dnight.framework.aop;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public class TargetSource {
    private Object target;

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    public TargetSource(Object target, Class<?> targetClass, Class<?>[] interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
