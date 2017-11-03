package com.example.service;

import java.util.List;

import com.example.model.*;
public interface StudentService
{
    StudentModel selectStudent (String npm);


    List<StudentModel> selectAllStudents ();


    void addStudent (StudentModel student);


    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
    CourseModel selectCourse(String id_course);
    void addCourse(String npm, String idCourse);
    List<CourseModel> selectAllCourses();
    
}
