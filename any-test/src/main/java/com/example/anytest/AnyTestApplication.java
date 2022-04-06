package com.example.anytest;

import com.example.anytest.postconstructanotaion.PostConstructAnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.beans.AppletInitializer;

@SpringBootApplication
public class AnyTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnyTestApplication.class, args);
    }

}
