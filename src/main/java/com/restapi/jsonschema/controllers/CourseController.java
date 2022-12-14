package com.restapi.jsonschema.controllers;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.restapi.jsonschema.services.CourseService;



@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses/{tablename}")
	public ResponseEntity<String> getAllCourses(@PathVariable String tablename){
		List<JSONObject> jsonObj =  this.courseService.getAllCourses(tablename);
		return (jsonObj.isEmpty() == true) ? new ResponseEntity<String>( "No Course FOUND", HttpStatus.NOT_FOUND) :
		 new ResponseEntity<String>( jsonObj.toString(), HttpStatus.OK);

	}
	@GetMapping("/courses/{tablename}/{courseId}")
	public ResponseEntity<String> getCourse(@PathVariable String tablename,  @PathVariable String courseId){
		List<JSONObject> jsonObj =  this.courseService.getCourse(Integer.parseInt(courseId), tablename);
		return (jsonObj.isEmpty() == true) ? new ResponseEntity<String>( "Course : "+ Integer.parseInt(courseId) + " - NOT FOUND", HttpStatus.NOT_FOUND) :
			 new ResponseEntity<String>( jsonObj.toString(), HttpStatus.OK);

	}

	@PostMapping("/courses/{tablename}")	
	@ResponseBody
	public ResponseEntity<String> addCourse(@RequestBody String json ,@PathVariable String tablename) throws JsonProcessingException{
		InputStream schemaAsStream = CourseController.class.getClassLoader().getResourceAsStream("model/courserequest.schema.json");
		JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(schemaAsStream);

		ObjectMapper om = new ObjectMapper();
		JsonNode jsonNode = om.readTree(json);

		Set<ValidationMessage> errors = schema.validate(jsonNode);
		String errorsCombined = "";
		for (ValidationMessage error : errors) {
			errorsCombined += error.toString() + "\n";
		}

		if (errors.size() > 0)
			throw new RuntimeException("Please fix your json! " + errorsCombined);

		this.courseService.addCourse(json,tablename);
		return new ResponseEntity<String>( json, HttpStatus.CREATED);
	}

	@DeleteMapping("/courses/{tablename}/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseId, @PathVariable String tablename){
		int update = this.courseService.deleteCourse(Integer.parseInt(courseId),tablename);
		return (update > 0) ?  new ResponseEntity<String>("Course : " + Integer.parseInt(courseId) + " DELETED SUCCESSFULLY",HttpStatus.OK): 
			new ResponseEntity<String>("Course : "+ Integer.parseInt(courseId) + " - NOT FOUND",HttpStatus.NOT_FOUND);
		
	}

}
