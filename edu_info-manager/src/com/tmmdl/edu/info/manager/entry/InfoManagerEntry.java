package com.tmmdl.edu.info.manager.entry;

import com.tmmdl.edu.info.manager.controller.StudentController;
import com.tmmdl.edu.info.manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("welcome student sys");
            System.out.println("please enter your needs 1,student controll 2,teacher control 3,exit");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("student con");
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("teacher con");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("thanks for your use");
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong interput ,");
                    break;
            }
        }
    }
}
