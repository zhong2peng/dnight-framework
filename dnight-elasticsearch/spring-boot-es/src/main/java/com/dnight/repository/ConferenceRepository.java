package com.dnight.repository;

import com.dnight.domain.ConferenceBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
@Repository
public interface ConferenceRepository extends ElasticsearchRepository<ConferenceBean, String> {
}
