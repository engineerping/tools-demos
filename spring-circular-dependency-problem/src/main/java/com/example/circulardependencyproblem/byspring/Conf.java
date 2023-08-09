package com.example.circulardependencyproblem.byspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
//@Configuration
public class Conf {

    @Bean
    public Teacher teacher1() {
        Teacher t = new Teacher();
        t.setName("t1");
        return t;
    }

    @Bean
    public Student student1() {
        Student s = new Student();
        s.setName("s1");
        return s;
    }
}
