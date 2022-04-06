package com.example.anytest.postconstructanotaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
@Controller
public class HelloController {

    /**
     * 只需要把这个bean 放到servlet 容器中，就可以出发@Constructor注解的方法执行,还可触发多个
     */
    @Autowired
    private PostConstructAnotation postConstructAnotation;
}
