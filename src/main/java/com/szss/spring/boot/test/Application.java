package com.szss.spring.boot.test;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zcg on 15/12/25.
 */


@SpringBootApplication
@MapperScan(basePackages = {"com.szss.spring.boot.test.mapper"})
public class Application {
    public static final void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
