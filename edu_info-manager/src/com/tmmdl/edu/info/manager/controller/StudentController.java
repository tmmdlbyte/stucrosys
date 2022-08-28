package com.tmmdl.edu.info.manager.controller;

import com.tmmdl.edu.info.manager.domain.Student;
import com.tmmdl.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        studentLoop:
        while (true) {
            System.out.println("welcome student sys");
            System.out.println("please enter your needs 1,add 2,delete 3,change 4view 5,exit");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("student add");
                    addStudent();
                    break;
                case "2":
                    System.out.println("student del");
                    break;
                case "3":
                    System.out.println("stu change");
                    break;
                case "4":
                    System.out.println("stu view");
                    findAllstudent();
                    break;
                case "5":
                    System.out.println("thanks for your use");
                    break studentLoop;
                default:
                    System.out.println("wrong interput ,");
                    break;
            }
        }
    }

    public void findAllstudent() {
        Student[] stus = studentService.findAllStudent();
        if (stus == null) {
            System.out.println("no student data exists,please add student data");
        } else {
            System.out.println("id\tname\tage\t\tbirthday\t");
            for (int i = 0; i < stus.length; i++) {
                Student stu = stus[i];
                if (stu != null) {
                    System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
                }
            }
        }
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);

        String id;
        while (true) {
            System.out.println("please enter student id");
            id = sc.next();
            boolean flag = StudentService.isExists(id);
            if (flag) {
                System.out.println("id is already exist");
            } else {
                break;
            }
        }
        System.out.println("please enter student name");
        String name = sc.next();
        System.out.println("please enter student age");
        String age = sc.next();
        System.out.println("please enter student birthday");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setAge(age);
        stu.setName(name);
        stu.setBirthday(birthday);
        boolean result = studentService.addStudent(stu);
        if (result) {
            System.out.println("add success");
        } else {
            System.out.println("add fail");
        }
    }
}
