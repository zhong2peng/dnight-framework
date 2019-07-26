package com.dnight;

import com.dnight.domain.ConferenceBean;
import com.dnight.repository.ConferenceRepository;
import org.elasticsearch.common.geo.GeoPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsUTApplication.class)
@TestExecutionListeners({MockitoTestExecutionListener.class})
public class ElasticsearchOperationsTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    ConferenceRepository repository;

    @Before
    public void init() {
        repository.deleteAll();
        operations.refresh(ConferenceBean.class);

        // Save data sample
        repository.save(ConferenceBean.builder().date("2014-11-06").name("Spring eXchange 2014 - London")
                .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(51.500152D, -0.126236D)).build());
        repository.save(ConferenceBean.builder().date("2014-12-07").name("Scala eXchange 2014 - London")
                .keywords(Arrays.asList("scala", "play", "java")).location(new GeoPoint(51.500152D, -0.126236D)).build());
        repository.save(ConferenceBean.builder().date("2014-11-20").name("Elasticsearch 2014 - Berlin")
                .keywords(Arrays.asList("java", "elasticsearch", "kibana")).location(new GeoPoint(52.5234051D, 13.4113999))
                .build());
        repository.save(ConferenceBean.builder().date("2014-11-12").name("AWS London 2014")
                .keywords(Arrays.asList("cloud", "aws")).location(new GeoPoint(51.500152D, -0.126236D)).build());
        repository.save(ConferenceBean.builder().date("2014-10-04").name("JDD14 - Cracow")
                .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(50.0646501D, 19.9449799)).build());
    }

    @Test
    public void textSearch() throws ParseException {

        String expectedDate = "2014-10-29";
        String expectedWord = "java";
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("keywords").contains(expectedWord).and(new Criteria("date").greaterThanEqual(expectedDate)));

        List<ConferenceBean> result = operations.queryForList(query, ConferenceBean.class);

        assertThat(result, hasSize(3));

        for (ConferenceBean conference : result) {
            assertThat(conference.getKeywords(), hasItem(expectedWord));
            assertThat(format.parse(conference.getDate()), greaterThan(format.parse(expectedDate)));
        }
    }

    @Test
    public void geoSpatialSearch() {

        GeoPoint startLocation = new GeoPoint(50.0646501D, 19.9449799D);
        String range = "330mi"; // or 530km
        CriteriaQuery query = new CriteriaQuery(new Criteria("location").within(String.valueOf(startLocation), range));

        List<ConferenceBean> result = operations.queryForList(query, ConferenceBean.class);

        assertThat(result, hasSize(2));
    }
}
