package com.dell.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.dell.login.mapper")

public class LoginApplication {
    @RequestMapping("/h")
    public String home(){
        return "Hello";
    }
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}
