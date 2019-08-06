package com.dnight.improve.dao;

import com.dnight.improve.LeaveApplication;
import com.dnight.improve.service.test.IHello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeaveApplication.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private IHello hello;

    @Test
    public void test() {
        bookRepository.getOne(1L);
    }
}
