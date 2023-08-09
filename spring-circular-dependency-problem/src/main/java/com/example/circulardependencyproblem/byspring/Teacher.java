package com.example.circulardependencyproblem.byspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
@Component
public class Teacher {
    private String name = "t2";

    @Autowired
    private Student student;

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", student‘s hashcode=" + student.hashCode() +
                '}';
    }
}
