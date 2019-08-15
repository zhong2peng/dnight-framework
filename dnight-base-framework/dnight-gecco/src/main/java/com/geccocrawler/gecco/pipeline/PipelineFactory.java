package com.geccocrawler.gecco.pipeline;

import com.geccocrawler.gecco.spider.SpiderBean;

public interface PipelineFactory {

    Pipeline<? extends SpiderBean> getPipeline(String name);

}
