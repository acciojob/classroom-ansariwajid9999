package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap = new HashMap<>();
    HashMap<String,Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> studentTeacherHashMap = new HashMap<>();
    public void addStudent(Student student){
        studentHashMap.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
        List<String> StudentList = studentTeacherHashMap.getOrDefault(teacher,new ArrayList<>());
        StudentList.add(student);
    }
    public Student getStudentByName(String name){
        Student student = studentHashMap.getOrDefault(name,null);
        return student;
    }
    public Teacher getTeacherByName(String name){
        Teacher teacher = teacherHashMap.getOrDefault(name,null);
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentTeacherHashMap.getOrDefault(teacher,new ArrayList<>());
    }
    public List<String> getAllStudents(){
        List<List<String>> AllStudents = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : studentTeacherHashMap.entrySet()){
            AllStudents.add(entry.getValue());
        }
        List<String> allStudents = AllStudents.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return allStudents;
    }
    public void deleteTeacherByName(String teacher){
        teacherHashMap.remove(teacher);
    }
    public void deleteAllTeachers(){
        for(Map.Entry<String,Teacher> entry : teacherHashMap.entrySet()){
            teacherHashMap.remove(entry.getKey());
        }
    }
}
