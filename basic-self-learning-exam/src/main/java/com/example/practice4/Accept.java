package com.example.practice4;
/**
 * 录取类
 */
class Accept {
    // 体育生的综合分数线
    private static final int CONST_INTGRET_RESULT = 300;
    //体育生的体育分数线
    private static final int CONST_SPORTS = 96;

    /**
     * 判断学生是否满足录取条件
     * @param student
     * @return
     */
    public static boolean isAccepted(Student student) {
        int[] scores = student.getScores();
        int intgretResult = scores[0];
        int sports = scores[1];

        if (intgretResult >= School.getScoreLine()) {
            return true;
        } else if (sports > CONST_SPORTS && sports > CONST_INTGRET_RESULT) {
            return true;
        }
        return false;
    }

    /**
     * 对满足条件的学生,输出其相信信息
     * @param args
     */
    public static void main(String[] args) {
        School.setScoreLine(500);
        Student zhangSan = new Student("张三", 1, 95, 600);
        Student liSi = new Student("李四", 2, 97, 400);
        Student wangWu = new Student("王五", 3, 95, 299);
        Student[] students = {zhangSan, liSi, wangWu};
        for (Student student : students) {
            if (isAccepted(student)) {
                System.out.println(student + " 被录取");
            }
        }
    }
}
