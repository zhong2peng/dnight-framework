package com.geccocrawler.gecco.downloader;

import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;

public interface AfterDownload {

    void process(HttpRequest request, HttpResponse response);

}
