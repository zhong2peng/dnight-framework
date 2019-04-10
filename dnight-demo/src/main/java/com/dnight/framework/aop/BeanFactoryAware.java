package com.dnight.framework.aop;

import com.dnight.framework.beans.factory.BeanFactory;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
