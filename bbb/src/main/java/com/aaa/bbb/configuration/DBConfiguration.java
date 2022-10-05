package com.aaa.bbb.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(datasource());
        ssfb.setMapperLocations(applicationContext.getResources("classpath:/*Mapper.xml"));
        return ssfb.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    public DataSource datasource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/springboot?characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("jyj10241103*");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;
    }

}
