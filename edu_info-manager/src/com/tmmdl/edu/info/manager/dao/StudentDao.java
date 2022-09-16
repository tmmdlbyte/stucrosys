package com.tmmdl.edu.info.manager.dao;

import com.tmmdl.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] stus = new Student[5];
    static {
        Student stu1 = new Student("12","akira","16","7-25");
        stus[0] = stu1;
    }

    public boolean addStudent(Student stu) {

        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student == null) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            stus[index] = stu;
            return true;
        } else {
            return false;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (id.equals(stu.getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        stus[index] = null;
    }

    public void changeStudentById(String chId, Student stu) {
        int index = getIndex(chId);
        stus[index] = stu;
    }
}
