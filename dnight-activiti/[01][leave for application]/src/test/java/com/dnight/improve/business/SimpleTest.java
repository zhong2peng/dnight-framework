//package com.dnight.improve.business;
//
//import com.dnight.improve.BaseTest;
//import com.dnight.improve.service.book.BookService;
//import com.dnight.improve.service.test.IHello;
//import org.activiti.engine.ProcessEngine;
//import org.activiti.engine.ProcessEngines;
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.repository.Deployment;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author ZHONGPENG769
// * @date 2019/8/5
// */
//public class SimpleTest extends BaseTest {
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private IHello hello;
//
//    @Autowired
//    private BookService bookService;
//
//    @Test
//    public void test(){
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        System.out.println("通过ProssessEngine构建引擎");
//        RepositoryService repositoryService = processEngine.getRepositoryService();
//        Deployment deployment = repositoryService.createDeployment()
//                .addClasspathResource("processes/leave.bpmn")
//                .name("请假单流程")
//                .category("办公类别")
//                .deploy();
//        System.out.println(deployment.getId());
//        System.out.println(deployment.getName());
//    }
//
//    @Test
//    public void test1(){
//        hello.sayHello();
//        ProcessInstance pi = runtimeService.startProcessInstanceByKey("leave");
//        String id = pi.getId();
//        System.out.println(id);
//    }
//}
