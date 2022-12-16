package com.fc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author fanchen
 * @Date 2022/10/25 12:17
 */
public class Ac {
    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("a", 30));
        students.add(new Student("b", 30));
        students.add(new Student("c", 30));
        students.add(new Student("d", 30));
        students.add(new Student("a", 30));
        students.add(new Student("c", 30));
        students.add(new Student("d", 30));
        students.add(new Student("a", 30));
        List<Student> newStudent = new ArrayList<>();
        students.stream().collect(Collectors.groupingBy(Student::getName)).entrySet().forEach(entry -> {
            newStudent.add(new Student(entry.getKey(), entry.getValue().stream().mapToInt(Student::getScore).sum()));
        });
        for (Student student : newStudent) {
            System.out.println(student.getName() + " " + student.getScore());
        }

        System.out.println("测试");
        System.out.println();
    }
}
