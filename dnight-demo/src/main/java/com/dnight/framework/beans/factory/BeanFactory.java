package com.dnight.framework.beans.factory;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public interface BeanFactory {
    Object getBean(String name)throws Exception;
}
