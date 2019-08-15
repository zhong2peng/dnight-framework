package com.geccocrawler.gecco.demo.sogouwx;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;


@Gecco(matchUrl = "http://mp.weixin.qq.com/s?{params}", pipelines = "consolePipeline")
@Data
public class Article implements HtmlBean {

    private static final long serialVersionUID = 5310736056776105882L;

    @Text(own = false)
    @HtmlField(cssPath = "body")
    private String body;

}
