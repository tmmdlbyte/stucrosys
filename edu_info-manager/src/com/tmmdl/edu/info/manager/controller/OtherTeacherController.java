package com.tmmdl.edu.info.manager.controller;

import com.tmmdl.edu.info.manager.domain.Teacher;
import com.tmmdl.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class OtherTeacherController extends BaseTeacherController {
    private Scanner sc = new Scanner(System.in);

    @Override
    public Teacher inputTeacherInfo(String id) {
        System.out.println("please enter  name");
        String name = sc.next();
        System.out.println("please enter  age");
        String age = sc.next();
        System.out.println("please enter  birthday");
        String birthday = sc.next();

        Teacher teacher = new Teacher(id, name, age, birthday);

        return teacher;
    }
}
