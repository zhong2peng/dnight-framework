package com.dnight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHONGPENG769
 * @date 2019/7/29
 */
@RestController("/")
@SpringBootApplication
public class ActiviDemoApplication {

    private final static Logger log = LoggerFactory.getLogger(ActiviDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ActiviDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            log.info("程序初始化...");
        };
    }

    @RequestMapping("test")
    public String test() {
        return "test";
    }
}
