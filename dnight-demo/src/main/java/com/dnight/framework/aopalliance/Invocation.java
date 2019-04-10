package com.dnight.framework.aopalliance;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface Invocation extends Joinpoint{
    Object[] getArguments();
}
