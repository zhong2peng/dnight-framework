package com.dnight.improve.controller.test;

import com.dnight.improve.service.test.IHello;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHONGPENG769
 * @date 2019/8/5
 */
@RestController
public class TestController {

    @Autowired
    private IHello hello;

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/hello")
    public void sayHello() {
        hello.sayHello();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("leave");
        System.out.println(pi.getId() + ", " + pi.getName());
    }
}
