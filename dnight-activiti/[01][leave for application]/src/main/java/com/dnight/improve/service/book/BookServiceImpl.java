package com.dnight.improve.service.book;

import com.dnight.improve.dao.BookRepository;
import com.dnight.improve.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author ZHONGPENG769
 * @date 2019/8/5
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
