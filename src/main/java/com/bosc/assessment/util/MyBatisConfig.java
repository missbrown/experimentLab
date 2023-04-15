package com.bosc.assessment.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {
    @Autowired
    private DataSource dataSource;


    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.afterPropertiesSet();
        SqlSessionFactory sessionFactory = factoryBean.getObject();
        return new SqlSessionTemplate(sessionFactory);
    }
}