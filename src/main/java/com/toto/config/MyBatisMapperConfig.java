package com.toto.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MyBatisMapperConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapper=new MapperScannerConfigurer();
        mapper.setBasePackage("com.toto.mapper");
        mapper.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapper;
    }
}
