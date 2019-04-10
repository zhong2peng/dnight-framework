package com.dnight.test.demo;

import com.dnight.framework.beandemo.Car;
import com.dnight.framework.beandemo.SimpleIOC;
import com.dnight.framework.beandemo.Wheel;
import org.junit.jupiter.api.Test;

/**
 * @author ZHONGPENG769
 * @date 2019/3/19
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SimpleIOCTest {
    @Test
    public void getBean() throws Exception{
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel)bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car)bf.getBean("car");
        System.out.println(car);
    }
}
