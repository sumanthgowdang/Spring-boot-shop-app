package com.restapi.jsonschema.dao;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public int insertCourse(String jsonObj, String tablename) {
		String id = "id";
		String name = "name";
		String description = "description";
		String query1 = "INSERT INTO " + tablename + " (select * from json_populate_record(NULL::" + tablename + " ,'" + jsonObj + "')) "
				+ "on conflict (" +id+ ") do update set("+id+","+name+","+description+")=(select * from json_populate_record(NULL::"+ tablename + " , '" + jsonObj + "'))";
		int update = this.jdbctemplate.update(query1);
		return update; 
	}

	public List<JSONObject> getCourses(String tablename){ 
		String query = "select row_to_json(row) as details from(select * from " + tablename + ") row";
		List<JSONObject> course =  (List<JSONObject>) jdbctemplate.query(query, new CourseRowMapper());
		return course;
	}

	public List<JSONObject> getCourse(int courseId, String tablename) {
		String query = "select row_to_json(row) as details from(select * from " + tablename + " where id=" +courseId + ") row";
		List<JSONObject> course =  (List<JSONObject>) jdbctemplate.query(query, new CourseRowMapper());
		return course;
	}

	public int deleteCourse(int courseId, String tablename) {
		String query="delete from "+tablename+ " where id= "+courseId;
		int update = this.jdbctemplate.update(query);
		return update; 

	}

}
