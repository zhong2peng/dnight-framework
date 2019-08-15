package com.geccocrawler.gecco.pipeline;

import com.geccocrawler.gecco.spider.SpiderBean;

public interface Pipeline<T extends SpiderBean> {

    void process(T bean);

}
