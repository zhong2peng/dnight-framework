package com.dnight.repository;

import com.dnight.domain.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
public interface BookRepository extends ElasticsearchRepository<BookBean, String> {

    Page<BookBean> findByAuthor(String author, Pageable pageable);

    Page<BookBean> findByTitle(String title, Pageable pageable);
}
