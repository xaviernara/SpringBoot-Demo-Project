package com.example.demo.Datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;


@Bean
@ConfigurationProperties("app.datasource")
public class PostgresDatasource {

    public HikariDataSource hikariDataSource(){

        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
