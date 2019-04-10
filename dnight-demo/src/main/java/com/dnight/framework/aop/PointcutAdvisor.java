package com.dnight.framework.aop;


/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
