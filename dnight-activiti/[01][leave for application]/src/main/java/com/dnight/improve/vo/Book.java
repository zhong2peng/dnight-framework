package com.dnight.improve.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * ID
     */
    @Column(name = "id")
    private Long id;

    /**
     * 书名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 出版日期
     */
    @Column(name = "publish_date")
    private Date publishDate;

    /**
     * 作者
     */
    @Column(name = "author_name")
    private String authorName;

    public Book() {
    }

    public Book(String bookName, Date publishDate, String authorName) {
        this.bookName = bookName;
        this.publishDate = publishDate;
        this.authorName = authorName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
