package com.example.anytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 开启AOP
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringKnowledgeApplication {

    public static void main(String[] args) {
        System.out.println(SpringBootVersion.getVersion());
        SpringApplication.run(SpringKnowledgeApplication.class, args);
    }

}
