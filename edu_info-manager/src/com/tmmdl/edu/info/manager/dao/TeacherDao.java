package com.tmmdl.edu.info.manager.dao;

import com.tmmdl.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teas = new Teacher[5];

    public boolean addTeacher(Teacher teacher) {
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher1 = new Teacher();
            teacher1 = teas[i];
            if (teacher1 == null) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            teas[index] = teacher;
            return true;
        } else {
            return false;
        }
    }

    public Teacher[] findAllteachers() {
        return teas;
    }

    public void deleteTeacherById(String id) {
        int index = getIndex((id));
        teas[index] = null;

    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher t = teas[i];
            if (t != null && t.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void changeTeacherById(String id, Teacher teacher) {
        int index = getIndex((id));
        teas[index]=teacher;
    }
}
