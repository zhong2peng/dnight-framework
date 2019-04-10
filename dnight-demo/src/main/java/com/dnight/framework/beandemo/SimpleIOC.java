package com.dnight.framework.beandemo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/3/19
 */
public class SimpleIOC {
    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIOC(String location) throws Exception{
        loadBeans(location);
    }

    public Object getBean(String name){
        Object bean = beanMap.get(name);
        if (null == bean){
            throw new IllegalArgumentException("there is no bean with name" + name);
        }
        return bean;
    }

    public void loadBeans(String location) throws Exception{
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++){
            Node node = nodes.item(i);
            if (node instanceof Element){
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                Class beanClass = null;
                try{
                    beanClass = Class.forName(className);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                    return;
                }
                Object bean = beanClass.newInstance();
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j<propertyNodes.getLength();j++){
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element){
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length()>0){
                            declaredField.set(bean, value);
                        }else{
                            String ref = propertyElement.getAttribute("ref");
                            if (null == ref || 0 == ref.length()){
                                throw new IllegalArgumentException("ref config error");
                            }
                            declaredField.set(bean, getBean(ref));
                        }
                        registerBean(id, bean);
                    }

                }
            }
        }
    }

    private void registerBean(String id, Object bean){
        beanMap.put(id, bean);
    }
}
