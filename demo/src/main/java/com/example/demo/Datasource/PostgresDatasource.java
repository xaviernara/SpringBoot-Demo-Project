package com.example.demo.Datasource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;

public class PostgresDatasource {

    public HikariDataSource hikariDataSource(){

        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
