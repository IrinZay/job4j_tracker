package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Irina Irinova");
        student.setGroup("j-8");
        student.setEntered(new Date());
        System.out.println("Студент - " + student.getName()
                + ", группа - " + student.getGroup()
                + ", дата поступления - " + student.getEntered());
    }
}
