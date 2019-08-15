package com.geccocrawler.gecco.downloader.proxy;

import org.apache.http.HttpHost;

public interface Proxys {

    HttpHost getProxy();

    boolean addProxy(String host, int port);

    boolean addProxy(String host, int port, String src);

    void failure(String host, int port);

    void success(String host, int port);

}
