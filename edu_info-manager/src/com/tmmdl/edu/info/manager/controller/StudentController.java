package com.tmmdl.edu.info.manager.controller;

import com.tmmdl.edu.info.manager.domain.Student;
import com.tmmdl.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController extends BaseStudentController {

    private Scanner sc = new Scanner(System.in);

    public Student inputStudentInfo(String id) {
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
