package com.tmmdl.edu.info.manager.controller;

import com.tmmdl.edu.info.manager.domain.Teacher;
import com.tmmdl.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController extends BaseTeacherController {
    private Scanner sc = new Scanner(System.in);

    public Teacher inputTeacherInfo(String id) {
        System.out.println("please enter  name");
        String name = sc.next();
        System.out.println("please enter  age");
        String age = sc.next();
        System.out.println("please enter  birthday");
        String birthday = sc.next();

        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setAge(age);
        teacher.setName(name);
        teacher.setBirthday(birthday);

        return teacher;
    }
}
