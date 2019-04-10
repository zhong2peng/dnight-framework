package com.dnight.framework.beans;

import com.dnight.framework.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
   private Map<String, BeanDefinition> registry;

   private ResourceLoader resourceLoader;

   protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
      this.registry = new HashMap<>();
      this.resourceLoader = resourceLoader;
   }

   public Map<String, BeanDefinition> getRegistry(){
      return registry;
   }

   public ResourceLoader getResourceLoader() {
      return resourceLoader;
   }
}
