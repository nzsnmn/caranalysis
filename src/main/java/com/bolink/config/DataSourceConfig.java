package com.bolink.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Primary
    @Bean(name = "bolinkDSProperties")
    @Qualifier("bolinkDSProperties")
    @ConfigurationProperties(prefix = "spring.datasource.bolink")
    public DataSourceProperties bolinkDSProperties(){//这是是用hikariCP的时候用的
        return new DataSourceProperties();
    }

    @Bean(name = "adDSProperties")
    @Qualifier("adDSProperties")
    @ConfigurationProperties(prefix = "spring.datasource.ad")
    public DataSourceProperties adDSProperties(){
        return new DataSourceProperties();
    }


    @Primary
    @Bean(name = "bolinkDS")
    @ConfigurationProperties(prefix = "spring.datasource.bolink")
    public DataSource dataSourceOrder(){
        //return DruidDataSourceBuilder.create().build(); //使用druidCP时打开这个注释，同时注释掉下面一行
        return  bolinkDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "adDS")
    @ConfigurationProperties(prefix = "spring.datasource.ad")
    public DataSource dataSourceAuth() {
        return  adDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}
