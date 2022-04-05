package com.trainingApplication.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.trainingApplication")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataBaseConfig {

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource,
                                         @Value("${hibernate.hbm2ddl.auto}") String ddl,
                                         @Value("${hibernate.dialect}") String dialect,
                                         @Value("${hibernate.show_sql}") String showSql,
                                         @Value("${hibernate.package.scan}") String packageScan
    ) throws IOException {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(packageScan);
        var hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", ddl);
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        hibernateProperties.setProperty("hibernate.show_sql", showSql);
        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.afterPropertiesSet();

        return sessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        var transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public DataSource dataSource(@Value("${database.url}") String databaseUrl,
                                 @Value("${database.user}") String databaseUser,
                                 @Value("${database.password}") String databasePassword,
                                 @Value("${database.driver}") String databaseDriver) {
        var datasource = new BasicDataSource();
        datasource.setUrl(databaseUrl);
        datasource.setUsername(databaseUser);
        datasource.setPassword(databasePassword);
        datasource.setDriverClassName(databaseDriver);
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
