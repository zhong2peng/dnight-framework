package com.dnight.framework.beans;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
