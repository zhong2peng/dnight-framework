package com.dnight.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Date;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
@Data
@Builder
@Document(indexName = "conference-index", type = "geo-class-point-type", shards = 1, replicas = 0,
        refreshInterval = "-1")
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceBean {

    @Id
    private String id;

    private String name;

    @Field(type = Date)
    private String date;

    private GeoPoint location;

    private List<String> keywords;
}
