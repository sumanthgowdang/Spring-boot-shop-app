package com.restapi.jsonschema.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Repository
public class CourseDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@SuppressWarnings("deprecation")
	public int insertCourse(String jsonstr, String tablename) {
		JsonObject jsonObj = new JsonParser().parse(jsonstr).getAsJsonObject();
		List<String> columnNames = new ArrayList<String>();
		Set<Entry<String, JsonElement>> entrySet = jsonObj.entrySet();
		for(Map.Entry<String,JsonElement> entry : entrySet){
			columnNames.add(entry.getKey());
		}
		String query = "INSERT INTO " + tablename + " (select * from json_populate_record(NULL::" + tablename + " ,'" + jsonObj + "')) "
				+ "on conflict (" +columnNames.get(0)+ ") do update set("+columnNames.get(0)+","+columnNames.get(1)+","+columnNames.get(2)+")=(select * from json_populate_record(NULL::"+ tablename + " , '" + jsonObj + "'))";
		int update = this.jdbctemplate.update(query);
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
