package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepositry {

    HashMap<String, Student> studentDb= new HashMap<>();
    HashMap<String, Teacher> teacherDb= new HashMap<>();
    HashMap<String, List<String>> studentTeacherDb= new HashMap<>();

    public void addStudent(Student student) {
        studentDb.put(student.getName(), student);

    }

    public void addTeacher(Teacher teacher) {
        teacherDb.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        // put mapping is only ofr existing case that's why we are checking in student and teacher db
        if (studentDb.containsKey(student) && teacherDb.containsKey((teacher))) {

            if (studentTeacherDb.containsKey(teacher)) {
                List<String> list = studentTeacherDb.get(teacher);
                list.add(student);
                studentTeacherDb.put(teacher, list);
            } else {
                List<String> al = new ArrayList<>();
                al.add(student);
                studentTeacherDb.put(teacher, al);
            }
        }
    }

    public Student getStudentByName(String name) {
        if(studentDb.containsKey(name)) {
            return studentDb.get(name);
        } else {
            return null;
        }
    }

    public Teacher getTeacherByName(String name) {
        if(teacherDb.containsKey(name)) {
            return teacherDb.get(name);
        } else {
            return null;
        }
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        if(studentTeacherDb.containsKey(teacher)) {
            return studentTeacherDb.get(teacher);
        } else {
            return new ArrayList<>();
        }
    }

    public List<String> getAllStudents() {
        List<String> ans = new ArrayList<>();
        for(String k: studentDb.keySet()) {
            ans.add(k);
        }
        return ans;
    }

    public void deleteTeacherByName(String teacher) {
        teacherDb.remove(teacher);

        List<String> al = studentTeacherDb.remove(teacher);
        for(int i=0; i<al.size(); i++) {
            String temp = al.get(i);
            studentDb.remove(temp);
        }
    }

    public void deleteAllTeachers() {

        for(String k: studentTeacherDb.keySet()) {
            teacherDb.remove(k);
            List<String> al = studentTeacherDb.remove(k);
            for(String p: al) {
                if(studentDb.containsKey(p)) {
                    studentDb.remove(p);
                }
            }
        }
    }
}