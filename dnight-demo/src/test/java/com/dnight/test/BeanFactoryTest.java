package com.dnight.test;

import com.dnight.framework.beans.BeanDefinition;
import com.dnight.framework.beans.factory.AbstractBeanFactory;
import com.dnight.framework.beans.factory.AutowireCapableBeanFactory;
import com.dnight.framework.beans.io.ResourceLoader;
import com.dnight.framework.beans.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/3/28
 */
public class BeanFactoryTest {


    @Test
    public void testLazy() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(
                new ResourceLoader()
        );
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
