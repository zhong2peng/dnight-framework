package com.geccocrawler.gecco.demo.test;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

/**
 * @author ZHONGPENG769
 * @date 2019/8/15
 */
@Gecco(matchUrl = "https://github.com/{user}/{project}", pipelines = "consolePipeline", timeout = 1000)
@Data
public class Test implements HtmlBean {

    private Request request;

    @RequestParameter("user")
    private String user;

    @RequestParameter("project")
    private String project;

    @Text
    @HtmlField(cssPath = "")
    private String title;

    private String star;

    private String usedBy;

    private String watch;

    private String stars;

    private String forks;
}
