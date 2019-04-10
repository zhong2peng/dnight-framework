package com.dnight.framework.aopalliance;

import java.lang.reflect.AccessibleObject;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface Joinpoint {
    Object proceed() throws Throwable;

    Object getThis();

    AccessibleObject getStaticPart();
}
