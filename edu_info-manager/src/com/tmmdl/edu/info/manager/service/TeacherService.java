package com.tmmdl.edu.info.manager.service;

import com.tmmdl.edu.info.manager.dao.TeacherDao;
import com.tmmdl.edu.info.manager.domain.Student;
import com.tmmdl.edu.info.manager.domain.Teacher;

public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();

    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public boolean isExists(String id) {
        Teacher[] teas = teacherDao.findAllteachers();
        boolean exists = false;
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher = teas[i];
            if (teacher != null && teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] allt = teacherDao.findAllteachers();
        boolean flag = false;
        for (int i = 0; i < allt.length; i++) {
            Teacher t = new Teacher();
            t = allt[i];
            if (t != null) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return allt;
        } else {
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void changeTeacherById(String id, Teacher teacher) {
        teacherDao.changeTeacherById(id,teacher);
    }
}
