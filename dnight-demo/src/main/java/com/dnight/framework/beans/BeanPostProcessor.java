package com.dnight.framework.beans;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
