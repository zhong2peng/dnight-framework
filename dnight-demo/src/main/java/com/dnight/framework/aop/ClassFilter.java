package com.dnight.framework.aop;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
