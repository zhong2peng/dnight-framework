package com.dnight.framework;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public class BeanReference {
    public String name;
    public Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
