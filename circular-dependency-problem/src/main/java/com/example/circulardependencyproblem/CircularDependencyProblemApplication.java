package com.example.circulardependencyproblem;

import com.example.circulardependencyproblem.byspring.Student;
import com.example.circulardependencyproblem.byspring.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircularDependencyProblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircularDependencyProblemApplication.class, args);
    }

}
