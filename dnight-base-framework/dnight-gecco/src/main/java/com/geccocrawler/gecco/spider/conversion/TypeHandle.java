package com.geccocrawler.gecco.spider.conversion;

public interface TypeHandle<T> {

    T getValue(Object src) throws Exception;

}
