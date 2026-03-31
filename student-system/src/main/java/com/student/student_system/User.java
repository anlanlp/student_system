package com.student.student_system;

public class User {
    private String name;
    private int age;
    private String grade;
    private String major;

    // 构造方法
    public User(String name, int age, String grade, String major) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    // Getter方法（必须有，否则接口返回空数据）
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }
    public String getMajor() { return major; }
}