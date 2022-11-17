package com.restapi.jsonschema.services;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.jsonschema.dao.CourseDao;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	public CourseServiceImpl() {		

	}

	@Override 
	public List<JSONObject> getCourse(int courseId , String tablename){
		List<JSONObject> course = this.courseDao.getCourse(courseId, tablename);
		return course;
	}
	 	
	@Override 
	public String addCourse(String course , String tablename) {
		this.courseDao.insertCourse(course,tablename); 
		return course;
	}

	@Override
	public int deleteCourse(int courseId,String tablename) {
		return this.courseDao.deleteCourse(courseId,tablename); 

	}

	@Override
	public List<JSONObject> getAllCourses(String tablename) {
		List<JSONObject> course = this.courseDao.getCourses(tablename);
		return course;		
	}

	@Override
	public String updateCourse(String course, String tablename) {
		// TODO Auto-generated method stub
		return null;
	}

}
