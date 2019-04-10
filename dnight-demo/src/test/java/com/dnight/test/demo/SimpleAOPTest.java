package com.dnight.test.demo;

import com.dnight.framework.aopdemo.*;
import org.junit.jupiter.api.Test;

/**
 * @author ZHONGPENG769
 * @date 2019/3/19
 */
public class SimpleAOPTest {

    @Test
    public void getProxy() throws Exception{
        MethodInvocation logTask = ()-> System.out.println("log task start");
        HelloServiceImpl helloService = new HelloServiceImpl();

        Advice beforeAdvice = new BeforeAdvice(helloService, logTask);
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloService, beforeAdvice);
        helloServiceImplProxy.sayHelloWorld();
    }
}
