package com.dnight.framework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValuesList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValuesList.add(pv);
    }

    public List<PropertyValue> getPropertyValuesList(){
        return propertyValuesList;
    }

}
