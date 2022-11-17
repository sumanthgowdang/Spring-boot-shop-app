package com.restapi.jsonschema.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;

public class CourseRowMapper implements RowMapper<JSONObject>{

	@Override
	public JSONObject mapRow(ResultSet resultSet, int i) throws SQLException {
		JSONObject row = new JSONObject(resultSet.getString("details"));
		return row;
	}

}
