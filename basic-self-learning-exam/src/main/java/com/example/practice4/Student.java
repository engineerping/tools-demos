package com.example.practice4;
/**
 * 学生类
 */
class Student {
    /** 姓名 */
    private String name;
    /** 考号 */
    private int id;
    /** 综合成绩 */
    private int intgretResult;
    /** 体育成绩 */
    private int sports;

    /**
     * 构造方法
     * @param name 姓名
     * @param id 考号
     * @param intgretResult 综合成绩
     * @param sports 体育成绩
     */
    public Student(String name, int id, int intgretResult, int sports) {
        this.name = name;
        this.id = id;
        this.intgretResult = intgretResult;
        this.sports = sports;
    }

    /**
     * 获取综合成绩与体育成绩
     * @return 存放 "综合成绩"与"体育成绩"的数组
     */
    public int[] getScores() {
        return new int[]{intgretResult, sports};
    }

    /**
     * 重写 tooString 方法
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", intgretResult=" + intgretResult +
                ", sports=" + sports +
                '}';
    }
}
