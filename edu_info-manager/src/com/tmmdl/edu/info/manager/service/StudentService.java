package com.tmmdl.edu.info.manager.service;

import com.tmmdl.edu.info.manager.dao.StudentDao;
import com.tmmdl.edu.info.manager.domain.Student;

public class StudentService {
    private static StudentDao studentDao = new StudentDao();

    public static boolean isExists(String id) {

        Student[] stus = studentDao.findAllStudent();
        boolean exists = false;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public boolean addStudent(Student stu) {

        return studentDao.addStudent(stu);
    }

    public Student[] findAllStudent() {
        Student[] stus = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu !=null){
                flag = true;
                break;
            }
        }
        if(flag){
            return stus;
        }else {
            return null;
        }
    }
}
