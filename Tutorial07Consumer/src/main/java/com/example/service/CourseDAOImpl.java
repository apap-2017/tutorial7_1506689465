package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.CourseDAO;
import com.example.model.CourseModel;

@Service
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public CourseModel selectCourse(String idCourse) {
		CourseModel course =
				restTemplate.getForObject("http://localhost:8080/rest/course/view/"+idCourse, CourseModel.class);
				return course;
	}
	
	@Override
	public List<CourseModel> selectAllCourses ()
	{
		ResponseEntity<CourseModel[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/rest/course/viewall", CourseModel[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
}
