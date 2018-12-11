package com.khmersdeal.khmersdeal.configurations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://35.247.143.236:5432/theKhmersDealDB");
        driverManagerDataSource.setUsername("db_user");
        driverManagerDataSource.setPassword("IT@$PringPr0j%c!");
        return driverManagerDataSource;
    }

}
