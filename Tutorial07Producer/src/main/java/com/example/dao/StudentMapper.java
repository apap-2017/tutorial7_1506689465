package com.example.dao;

import java.util.List;


import org.apache.ibatis.annotations.*;
import com.example.model.StudentModel;
import com.example.model.CourseModel;

@Mapper
public interface StudentMapper
{
	  @Select("select student.npm , name, gpa " + "from studentcourse join student " + "on studentcourse.npm = student.npm " + "where studentcourse.id_course = #{id_course}")
	    List<StudentModel> selectStudents (@Param("id_course") String id_course);
	    
	  @Select("select course.id_course, name, credits from course")
	  @Results(value = {
	    		@Result(property = "idCourse", column ="id_course"),
	    		@Result(property = "name", column = "name"),
	    		@Result(property = "credits", column = "credits"),
	    		@Result(property = "students", column ="id_course" ,
				javaType = List.class,
			many = @Many(select = "selectStudents"))
	  })
	    List<CourseModel> selectAllCourses();
	    
	   
	    @Select("select name, id_course, credits from course where id_course = #{idCourse}")
	    
	    @Results(value = {
	    		@Result(property = "idCourse", column ="id_course"),
	    		@Result(property = "name", column = "name"),
	    		@Result(property = "credits", column = "credits"),
	    		@Result(property = "students", column ="id_course" ,
	    				javaType = List.class,
	    			many = @Many(select = "selectStudents"))
	    		
	    		
	    		
	    })
	    
	    CourseModel selectCourse (@Param("idCourse") String idCourse);
    @Select("select npm, name, gpa from student where npm = #{npm}")
    @Results(value = {
    		@Result(property = "npm", column ="npm"),
    		@Result(property = "name", column = "name"),
    		@Result(property = "gpa", column = "gpa"),
    		@Result(property = "courses", column ="npm" ,
    				javaType = List.class,
    			many = @Many(select = "selectCourses"))
    		
    		
    		
    })
    StudentModel selectStudent (@Param("npm") String npm);

    @Select("select npm, name, gpa from student")
    @Results(value = {
    		@Result(property = "npm", column ="npm"),
    		@Result(property = "name", column = "name"),
    		@Result(property = "gpa", column = "gpa"),
    		@Result(property = "courses", column ="npm" ,
    				javaType = List.class,
    			many = @Many(select = "selectCourses"))
    		
    		
    		
    })
    List<StudentModel> selectAllStudents ();


    @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    void addStudent (StudentModel student);
    
    @Delete("DELETE FROM student where npm = #{npm}")
    void deleteStudent(@Param("npm") String npm);
    
    @Update("UPDATE student SET name = #{name} , gpa = #{gpa} WHERE npm =#{npm} ")
    void updateStudent(StudentModel student);
    
    @Select("select course.id_course, name, credits " + "from studentcourse join course " + "on studentcourse.id_course = course.id_course " + "where studentcourse.npm = #{npm}")
    List<CourseModel> selectCourses (@Param("npm") String npm);
}
