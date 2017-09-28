package com.citypak.sandbox.config;

import com.citypak.sandbox.dao.bangloreDao;
import com.citypak.sandbox.dao.regionDao;
import com.citypak.sandbox.daoimpl.BangloreDaoImpl;
import com.citypak.sandbox.daoimpl.RegionDaoImpl;


import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.citypak.sandbox")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/banglore");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        return dataSource;
    }

    @Bean
    public bangloreDao getbangloreDao() {
     return new BangloreDaoImpl (getDataSource());
    }

    @Bean
    public regionDao getActionDAO() {
       return new RegionDaoImpl(getDataSource());
    }

}
