package com.example.service;

import java.util.List;

import com.example.model.*;
public interface StudentService
{
    StudentModel selectStudent (String npm);


    List<StudentModel> selectAllStudents ();
   List<CourseModel> selectAllCourses();

    void addStudent (StudentModel student);


    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
    CourseModel selectCourse(String id_course);
    
    
}
