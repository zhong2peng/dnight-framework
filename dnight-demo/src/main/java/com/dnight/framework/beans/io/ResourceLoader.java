package com.dnight.framework.beans.io;

import java.net.URL;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
