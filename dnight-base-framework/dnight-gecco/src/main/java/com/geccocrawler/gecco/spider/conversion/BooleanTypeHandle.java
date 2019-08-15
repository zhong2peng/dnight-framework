package com.geccocrawler.gecco.spider.conversion;

public class BooleanTypeHandle implements TypeHandle<Boolean> {

    @Override
    public Boolean getValue(Object src) {
        return Boolean.valueOf(src.toString().toLowerCase());
    }

}
