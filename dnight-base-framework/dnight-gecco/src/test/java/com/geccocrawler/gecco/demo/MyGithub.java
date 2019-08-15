package com.geccocrawler.gecco.demo;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

@Gecco(matchUrl = "https://github.com/{user}/{project}", pipelines = "consolePipeline", timeout = 1000)
@Data
public class MyGithub implements HtmlBean {

    private static final long serialVersionUID = -7127412585200687225L;

    @Request
    private HttpRequest request;

    @RequestParameter("user")
    private String user;

    @RequestParameter("project")
    private String project;

    @Text(own = false)
    @HtmlField(cssPath = "#repo-meta-edit span.text-gray-dark.mr-2")
    private String title;

    @Text(own = false)
    @HtmlField(cssPath = ".pagehead-actions li:nth-child(2) .social-count")
    private String star;

    @Text
    @HtmlField(cssPath = ".pagehead-actions li:nth-child(3) .social-count")
    private int fork;

    @Href
    @HtmlField(cssPath = "ul.numbers-summary > li:nth-child(4) > a")
    private String contributors;

    //@HtmlField(cssPath=".entry-content")
    private String readme;


    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("com.geccocrawler.gecco.demo")
                //开始抓取的页面地址
                .start("https://github.com/xtuhcy/gecco")
                .start("https://github.com/xtuhcy/gecco-spring")
                //开启几个爬虫线程,线程数量最好不要大于start request数量
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                //循环抓取
                .loop(false)
                //采用pc端userAgent
                .mobile(false)
                //是否开启debug模式，跟踪页面元素抽取
                .debug(false)
                //非阻塞方式运行
                .start();
    }

}
