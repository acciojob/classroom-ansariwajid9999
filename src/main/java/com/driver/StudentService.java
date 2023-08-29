package com.driver;

import java.util.List;

public class StudentService {

    StudentRepositry studentRepositry= new StudentRepositry();

    public  void addStudent(Student student) {
        studentRepositry.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepositry.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepositry.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepositry.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepositry.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        return studentRepositry.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepositry.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepositry.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepositry.deleteAllTeachers();
    }
}