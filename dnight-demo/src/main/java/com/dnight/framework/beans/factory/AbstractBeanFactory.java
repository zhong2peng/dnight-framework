package com.dnight.framework.beans.factory;

import com.dnight.framework.beans.BeanDefinition;
import com.dnight.framework.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public class AbstractBeanFactory implements BeanFactory{

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (null == beanDefinition){
            throw new IllegalArgumentException("No bean named "+name+" is defined");
        }
        Object bean = beanDefinition.getBean();
        if (null == bean){
            bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean, name);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    protected Object initializeBean(Object bean, String name) throws Exception{
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors){
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors){
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    public void preInstantiateSingletons() throws Exception{
        Iterator it = this.beanDefinitionNames.iterator();
        while (it.hasNext()){
            String beanName = (String)it.next();
            getBean(beanName);
        }
    }

    public List getBeansForType(Class type) throws Exception{
        List beans = new ArrayList();
        for (String beanDefinitionName : beanDefinitionNames){
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())){
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor)throws  Exception{
        this.beanPostProcessors.add(beanPostProcessor);
    }
}
