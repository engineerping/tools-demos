package com.example.circulardependencyproblem.manually;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();

//        teacher.student = student;
//        student.teacher = teacher;
        teacher.setName("t1");
        teacher.setStudent(student);

        student.setName("s1");
        student.setTeacher(teacher);

        System.out.println(teacher);
        System.out.println(student);
    }
}
