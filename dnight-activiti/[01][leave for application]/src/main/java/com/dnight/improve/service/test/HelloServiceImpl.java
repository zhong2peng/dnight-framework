package com.dnight.improve.service.test;

import org.springframework.stereotype.Service;

/**
 * @author ZHONGPENG769
 * @date 2019/8/5
 */
@Service
public class HelloServiceImpl implements IHello {
    @Override
    public void sayHello() {
        System.out.println("GG");
    }
}
