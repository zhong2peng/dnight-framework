package com.dnight.framework.aop;

import com.dnight.framework.aopalliance.Advice;
import com.dnight.framework.aopalliance.MethodInterceptor;
import com.dnight.framework.aopdemo.MethodInvocation;
import com.dnight.framework.beans.factory.BeanFactory;

import java.lang.reflect.Method;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public class AspectJAroundAdvice implements Advice, MethodInterceptor {

    private BeanFactory beanFactory;
    private Method aspectJAdviceMethod;
    private String aspectInstanceName;


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectInstanceName), invocation);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Method getAspectJAdviceMethod() {
        return aspectJAdviceMethod;
    }

    public void setAspectJAdviceMethod(Method aspectJAdviceMethod) {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
    }

    public String getAspectInstanceName() {
        return aspectInstanceName;
    }

    public void setAspectInstanceName(String aspectInstanceName) {
        this.aspectInstanceName = aspectInstanceName;
    }
}
