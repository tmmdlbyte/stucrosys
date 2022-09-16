package com.tmmdl.edu.info.manager.controller;

import com.tmmdl.edu.info.manager.domain.Teacher;
import com.tmmdl.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public abstract class BaseTeacherController {
    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    public void start() {
        TeacherLoop:
        while (true) {
            System.out.println("welcome teacher sys");
            System.out.println("please enter your needs 1,add 2,delete 3,change 4view 5,exit");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("teacher add");
                    addTeacher();
                    break;
                case "2":
                    System.out.println("teacher del");
                    deleteTeacherById();
                    break;
                case "3":
                    System.out.println("teacher change");
                    changeTeacherById();
                    break;
                case "4":
                    System.out.println("teacher view");
                    viewTeacher();
                    break;
                case "5":
                    System.out.println("thanks for your use");
                    break TeacherLoop;
                default:
                    System.out.println("wrong interput ,");
                    break;
            }
        }
    }

    public void changeTeacherById() {
        String id=inputTeacherId();
        Teacher teacher = inputTeacherInfo(id);

        teacherService.changeTeacherById(id, teacher);

    }

    public void deleteTeacherById() {
        String id=inputTeacherId();
        teacherService.deleteTeacherById(id);
        System.out.println("delete successful");
    }

    public void viewTeacher() {
        Teacher[] teas = teacherService.findAllTeacher();
        if (teas == null) {
            System.out.println("none data,please add first");
            return;
        }
        System.out.println("id\tname\tage\t\tbirthday\t");
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher = teas[i];
            if (teacher != null) {
                System.out.println(teacher.getId() + "\t" + teacher.getName() + "\t" + teacher.getAge() + "\t\t" + teacher.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("please enter teacher id");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (exists) {
                System.out.println("the id  isalready exist, please enter once again");
            } else {
                break;
            }
        }
        Teacher teacher = inputTeacherInfo(id);

        boolean flag = teacherService.addTeacher(teacher);
        if (flag) {
            System.out.println("add success");
        } else {
            System.out.println("add fail,the [] is flow");
        }
    }

    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("please enter the id which want delete");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (!exists) {
                System.out.println("the id not exist");
            } else {
                break;
            }
        }
        return id;
    }

    public abstract Teacher inputTeacherInfo(String id) ;
}
