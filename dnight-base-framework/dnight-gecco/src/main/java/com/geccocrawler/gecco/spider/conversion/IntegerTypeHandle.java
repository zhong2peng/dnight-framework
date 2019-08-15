package com.geccocrawler.gecco.spider.conversion;

public class IntegerTypeHandle implements TypeHandle<Integer> {

    @Override
    public Integer getValue(Object src) {
        return Integer.valueOf(src.toString());
    }

}
