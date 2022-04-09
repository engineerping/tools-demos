package com.example.circulardependencyproblem.manually;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class Test {
    public static void main(String[] args) {
        /*
        放在spring容器的三级缓存中
         */
        Teacher teacher = new Teacher();
        Student student = new Student();

        /*
        放在spring 容器的耳机缓存中，包括动态代理增强的对象
         */
        teacher.setName("t1");
        teacher.setStudent(student);
        student.setName("s1");
        student.setTeacher(teacher);

        /*
        放在spring容器的一级缓存中
         */
        System.out.println(teacher);
        System.out.println(student);
    }
}
