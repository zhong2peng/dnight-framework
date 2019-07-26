package com.dnight.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.*;
import java.net.URI;

/**
 * @author ZHONGPENG769
 * @date 2019/7/25
 */
public class FileCopyWithProgress {

    public static void main(String[] args) throws IOException {
        String localSrc = "/Users/zhongpeng/Documents/export.json";
        String dst = "hdfs://localhost:9000/";
        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
        Configuration configuration = new Configuration();
        configuration.set("HADOOP_USER_NAME", "root");
        FileSystem fs = FileSystem.get(URI.create(dst), configuration);
        OutputStream out = fs.create(new Path(dst), new Progressable() {
            @Override
            public void progress() {
                System.out.println(".");
            }
        });
        IOUtils.copyBytes(in, out, 4096, true);

    }
}
