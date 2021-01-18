package com.example.elearning;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config{

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/elearning?serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void dbInit(){
//        String sqlCourse = "Create TABLE Course(id INT NOT NULL UNIQUE, price INT NOT NULL, name varchar(50) NOT NULL, description varchar(500) NOT NULL);";
//        String sqlLesson = "Create TABLE Lesson(id INT NOT NULL UNIQUE, duration_time varchar(50) NOT NULL, notes varchar(1000));";
//        String sqlWishlist = "Create TABLE Wishlist(id INT NOT NULL UNIQUE, quantity INT NOT NULL );";
//        String sqlShoppingCart = "Create TABLE ShoppingCart(id INT NOT NULL UNIQUE , quantity INT NOT NULL);";
//        String sqlCustomer = "Create TABLE Customer(id INT NOT NULL UNIQUE , first_name varchar(50) NOT NULL, last_name varchar(50) NOT NULL);";
//        String sqlUser = "Create TABLE User(id INT NOT NULL UNIQUE , username varchar(30) NOT NULL, password varchar(50) NOT NULL, loginStatus varchar(50) NOT NULL, registerDate varchar(30) NOT NULL);";
//
//        getJdbcTemplate().update(sqlCourse);
//        getJdbcTemplate().update(sqlLesson);
//        getJdbcTemplate().update(sqlWishlist);
//        getJdbcTemplate().update(sqlShoppingCart);
//        getJdbcTemplate().update(sqlUser);
//        getJdbcTemplate().update(sqlCustomer);
//
//    }

}