package com.dnight.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
@Document(indexName = "book", type = "_doc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBean {

    @Id
    private String id;
    private String title;
    private String author;
    private String postDate;

}
