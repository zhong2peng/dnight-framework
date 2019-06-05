package com.dnight.base.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ZHONGPENG769
 * @date 2019/5/28
 */
@SpringBootApplication(scanBasePackages = { "com.dnight.base" })
@EnableTransactionManagement
@EnableRedisHttpSession
public class StandardWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StandardWebApplication.class, args);
    }
}
