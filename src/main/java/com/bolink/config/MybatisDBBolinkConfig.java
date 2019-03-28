package com.bolink.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.bolink.mapper.bolinkdb"}, sqlSessionFactoryRef = "bolinkSqlSessionFactory")
public class MybatisDBBolinkConfig {

    @Autowired
    @Qualifier("bolinkDS")
    private DataSource bolinkDS;

    @Bean(name = "bolinkSqlSessionFactory")
    public SqlSessionFactory bolinkSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(bolinkDS);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/bolink/*.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "bolinkSqlSessionTemplate")
    public SqlSessionTemplate bolinkSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(bolinkSqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean(name = "bolinkDataSourceTransactionManager")
    public DataSourceTransactionManager bolinkDataSourceTransactionManager() throws Exception{
        DataSourceTransactionManager manager = new DataSourceTransactionManager(bolinkDS);
        return manager;
    }

}
