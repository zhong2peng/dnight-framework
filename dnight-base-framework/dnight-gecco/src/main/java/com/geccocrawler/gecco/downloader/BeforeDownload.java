package com.geccocrawler.gecco.downloader;

import com.geccocrawler.gecco.request.HttpRequest;

public interface BeforeDownload {

    void process(HttpRequest request);

}
