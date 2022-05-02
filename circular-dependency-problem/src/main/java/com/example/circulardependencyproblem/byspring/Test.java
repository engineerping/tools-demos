package com.example.circulardependencyproblem.byspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.applet.AppletContext;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
@Component
public class Test implements ApplicationContextAware {

    @Autowired
    private Teacher teacher;

    @Autowired
    private Student student;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(teacher);
        System.out.println(student);
    }
}
