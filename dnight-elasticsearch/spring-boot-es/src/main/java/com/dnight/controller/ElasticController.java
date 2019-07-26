package com.dnight.controller;

import com.dnight.domain.BookBean;
import com.dnight.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
@RestController
public class ElasticController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{id}")
    public BookBean getBookById(@PathVariable String id) {
        return bookService.findById(id).get();
    }

    @PostMapping("/book")
    public void save(@RequestBody BookBean bookBean) {
        bookService.save(bookBean);
    }
}
