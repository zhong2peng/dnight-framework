package com.dnight.improve.controller.book;

import com.dnight.improve.service.book.BookService;
import com.dnight.improve.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ZHONGPENG769
 * @date 2019/8/5
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/add")
    public String addBook() {
        Book book = new Book("spring-boot", new Date(), "zp");
        bookService.addBook(book);
        return "success";
    }
}
