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
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/** DataSourceConfiguration */
@Configuration
@ConditionalOnProperty("spring.datasource.business.url")
@EnableJpaRepositories(
  entityManagerFactoryRef = "businessEntityManagerFactory",
  transactionManagerRef = "businessTxManager",
  basePackages = {"com.dnight.base.framework.account"}
)
public class DataSourceBusinessConfig implements TransactionManagementConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(DataSourceBusinessConfig.class);

  @Resource(name = "businessTxManager")
  private PlatformTransactionManager businessTxManager;

  @Bean(name = "businessJpaProperties")
  @ConfigurationProperties("spring.jpa.business")
  public JpaProperties jpaProperties() {
    return new JpaProperties();
  }

  @Bean(name = "businessHibernateProperties")
  @ConfigurationProperties("spring.datasource.business.hibernate")
  public HibernateProperties hibernateProperties() {
    return new HibernateProperties();
  }

  @Bean(name = "businessDataSource", destroyMethod = "close", initMethod = "init")
  @ConfigurationProperties("spring.datasource.business")
  public DataSource businessDataSource() {
    return new DruidDataSource();
  }

  @Bean("businessEntityManager")
  public EntityManager entityManager(EntityManagerFactoryBuilder build) {
    return businessEntityManagerFactory(build).getObject().createEntityManager();
  }

  @Bean("businessEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean businessEntityManagerFactory(
      EntityManagerFactoryBuilder build) {
    Map<String, Object> stringObjectMap =
        hibernateProperties()
            .determineHibernateProperties(jpaProperties().getProperties(), new HibernateSettings());

    return build
        .dataSource(businessDataSource())
        .properties(stringObjectMap)
        .packages("com.dnight.base.framework.account")
        .persistenceUnit("businessPersistenceUnit")
        .build();
  }

  @Bean(name = "businessTxManager")
  public PlatformTransactionManager transactionManager1(EntityManagerFactoryBuilder build) {
    return new JpaTransactionManager(businessEntityManagerFactory(build).getObject());
  }

  @Bean
  public AuditorAware<Long> auditorProvider() {
    return new DefaultAuditorAwareImpl();
  }

  @Bean(name = "businessJdbcTemplate")
  public JdbcTemplate businessJdbcTemplate() {
    return new JdbcTemplate(businessDataSource());
  }

  @Override
  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return businessTxManager;
  }
}
