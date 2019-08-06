package com.dnight.improve;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ZHONGPENG769
 * @date 2019/8/5
 */
@SpringBootApplication(scanBasePackages = {"com.dnight.improve"},
        exclude = SecurityAutoConfiguration.class)
@EnableTransactionManagement
@EnableJpaAuditing
public class LeaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaveApplication.class, args);
    }
}
