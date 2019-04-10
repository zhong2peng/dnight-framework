package com.dnight.framework.aopalliance;

import java.lang.reflect.Method;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface MethodInvocation extends Invocation {
    Method getMethod();
}
