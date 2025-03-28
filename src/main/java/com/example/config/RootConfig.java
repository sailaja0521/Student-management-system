package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy  // Enable aspect-oriented programming (if using AOP)
@EnableTransactionManagement  // Enable transaction management (for JPA or JDBC)
@ComponentScan(basePackages = "com.example") // Specify the base package for Spring to scan for beans
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Studentsss?useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("Sailu@123");
        return dataSource;
    }

    // You can add other beans here as needed, such as a transaction manager or JPA configurations
}
