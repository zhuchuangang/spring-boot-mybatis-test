package com.szss.spring.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zcg on 15/12/24.
 */
@SpringBootApplication
@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String home(){
        return "HelloWorld";
    }

    public static final void main(String[] args){
        SpringApplication.run(HelloWorld.class,args);
    }
}
