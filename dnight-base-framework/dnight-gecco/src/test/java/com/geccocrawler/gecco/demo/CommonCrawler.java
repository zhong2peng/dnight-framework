package com.geccocrawler.gecco.demo;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

@Gecco(pipelines = "consolePipeline")
@Data
public class CommonCrawler implements HtmlBean {

    private static final long serialVersionUID = -8870768223740844229L;

    @Request
    private HttpRequest request;

    @Text(own = false)
    @HtmlField(cssPath = "body")
    private String body;

    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("com.geccocrawler.gecco.demo")
                .start("https://www.baidu.com/")
                .interval(2000)
                .start();
    }
}
