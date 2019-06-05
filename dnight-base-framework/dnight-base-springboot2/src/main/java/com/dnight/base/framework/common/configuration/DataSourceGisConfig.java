package com.dnight.base.framework.common.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * DataSourceConfiguration
 */
@Configuration
@ConditionalOnProperty("spring.datasource.gis.url")
@EnableJpaRepositories(entityManagerFactoryRef = "gisEntityManagerFactory",
        transactionManagerRef = "gisTxManager",
        basePackages = "com.dnight.base.framework.manage")
public class DataSourceGisConfig {
    private final static Logger logger = LoggerFactory.getLogger(DataSourceGisConfig.class);

    @Bean(name = "gisJpaProperties")
    @ConfigurationProperties("spring.jpa.gis")
    @Primary
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    @Bean(name = "gisHibernateProperties")
    @ConfigurationProperties("spring.jpa.gis.hibernate")
    @Primary
    public HibernateProperties hibernateProperties() {
        return new HibernateProperties();
    }

    @Bean(name = "gisDataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties("spring.datasource.gis")
    @Primary
    public DataSource gisDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean("gisEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder build) {
        return gisEntityManagerFactory(build).getObject().createEntityManager();

    }

    @Primary
    @Bean("gisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean gisEntityManagerFactory(EntityManagerFactoryBuilder build) {
        Map<String, Object> stringObjectMap = hibernateProperties()
                .determineHibernateProperties(jpaProperties().getProperties(), new HibernateSettings());
        return build.dataSource(gisDataSource()).properties(stringObjectMap).
                packages("com.dnight.base.framework.manage").
                persistenceUnit("gisPersistenceUnit").build();
    }

    @Bean(name = "gisTxManager")
    @Primary
    public PlatformTransactionManager transactionManager1(EntityManagerFactoryBuilder build) {
        return new JpaTransactionManager(gisEntityManagerFactory(build).getObject());
    }

    @Bean(name = "gisJdbcTemplate")
    @Primary
    public JdbcTemplate gisJdbcTemplate() {
        return new JdbcTemplate(gisDataSource());
    }


}
