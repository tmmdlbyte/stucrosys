package com.tmmdl.edu.info.manager.controller;

import com.tmmdl.edu.info.manager.domain.Student;
import com.tmmdl.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
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
                    deleteStudentById();
                    break;
                case "3":
                    System.out.println("stu change");
                    changStudentById();
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

    public void changStudentById() {
        String chId;
        String chName;
        String chAge;
        String chbir;
        chId = inputStudentId();
        Student stu=inputStudentInfo(chId);
        studentService.changeStudentById(chId, stu);
        System.out.println("change sucessful");
    }


    public void deleteStudentById() {
        String DelId = inputStudentId();
        studentService.deleteStudentById(DelId);
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
        Student stu=inputStudentInfo(id);
        boolean result = studentService.addStudent(stu);
        if (result) {
            System.out.println("add success");
        } else {
            System.out.println("add fail");
        }
    }

    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("please enter id");
            id = sc.next();
            boolean exist = StudentService.isExists(id);
            if (exist) {
                break;
            } else {
                System.out.println("this id not exist, please enter once again");
            }
        }
        return id;
    }
    public Student inputStudentInfo(String id){
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
        return stu;
    }
}
