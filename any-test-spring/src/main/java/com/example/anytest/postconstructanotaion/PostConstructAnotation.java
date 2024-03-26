package com.example.anytest.postconstructanotaion;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
@Component
public class PostConstructAnotation {
    public PostConstructAnotation() {
        System.out.println("Constructor...");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstructor...");
    }

    @PostConstruct
    public void init2() {
        System.out.println("PostConstructor...2");
    }

    @PreDestroy
    public void preDextroy() {
        System.out.println("preDextroy...");
    }

    @PreDestroy
    public void preDextroy2() {
        System.out.println("preDextroy...2");
    }
    public void caller() {
        System.out.println("I am a normal method");
    }

    /**
     * 用main 方法调用，是不会触发@PostConstructor的。它只在servlet 容器中有效
     * 尽管 @PostConstruct 来自于javax.annotation.PostConstruct
     * @param args
     */
//    public static void main(String[] args) {
//        //用main 方法调用，是不会触发@PostConstructor
//        PostConstructAnotation pa = new PostConstructAnotation();
//        System.out.println("Created instance");
//    }
}
