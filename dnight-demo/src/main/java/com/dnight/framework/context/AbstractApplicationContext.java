package com.dnight.framework.context;

import com.dnight.framework.beans.BeanPostProcessor;
import com.dnight.framework.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/3/26
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
        loadBeanDefinition(beanFactory);
        registerBeanPostProcessors(beanFactory);
    }

    public void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception{
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors){
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected abstract void loadBeanDefinition(AbstractBeanFactory beanFactory) throws Exception;

    protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
