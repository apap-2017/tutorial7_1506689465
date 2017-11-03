package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.CourseModel;
import com.example.model.StudentModel;
public interface StudentDAO {
	StudentModel selectStudent (String npm);
	List<StudentModel> selectAllStudents ();
}
