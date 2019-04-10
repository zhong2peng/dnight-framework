package com.dnight.framework.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZHONGPENG769
 * @date 2019/3/25
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
