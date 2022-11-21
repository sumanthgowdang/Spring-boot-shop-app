package com.restapi.jsonschema.services;

import java.util.List;
import org.json.JSONObject;

public interface CourseService {
	
	public List<JSONObject> getAllCourses(String tablename);

	public List<JSONObject> getCourse(int parseInt, String tablename);
	
	public String addCourse(String requestStr, String json);

	public int deleteCourse(int parseInt, String tablename);
	
}
