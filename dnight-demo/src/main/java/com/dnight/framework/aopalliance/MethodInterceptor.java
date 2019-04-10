package com.dnight.framework.aopalliance;

import com.dnight.framework.aopdemo.MethodInvocation;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface MethodInterceptor extends Interceptor {
    Object invoke(MethodInvocation invocation) throws Throwable;
}
