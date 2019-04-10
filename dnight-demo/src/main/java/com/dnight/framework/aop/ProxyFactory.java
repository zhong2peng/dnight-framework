package com.dnight.framework.aop;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy{

    @Override
    public Object getProxy() {
        return null;
    }

    protected final AopProxy createAopProxy(){
        return (AopProxy) new Cglib2AopProxy(this);
    }
}
