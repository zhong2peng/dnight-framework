package com.dnight.framework.aop;

import java.lang.reflect.Method;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetCLass);
}
