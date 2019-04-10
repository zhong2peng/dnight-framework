package com.dnight.framework.aop;

import com.dnight.framework.aopdemo.AopProxy;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
