package com.example.event.addeventbyannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) //Retention中文意思是“保留”
public @interface ActionListenerFor {
    String source();
}
