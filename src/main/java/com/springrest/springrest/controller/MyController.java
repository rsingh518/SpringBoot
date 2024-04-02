package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseSerivice;

	@GetMapping("/home")
	public String home() {
		return "Home page";
	}

	// get course
	@CrossOrigin
	@GetMapping("/courses")
	public List<Course> course() {
		return this.courseSerivice.getCourse();
	}

	@CrossOrigin
	@GetMapping("/courses/{courseId}")
	public Course course(@PathVariable String courseId) {
		return this.courseSerivice.getCourse(Long.parseLong(courseId));
	}

	@CrossOrigin
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseSerivice.addCourse(course);
	}

	// update course using PUT request

	@CrossOrigin
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseSerivice.updateCourse(course);
	}
	// delete the course

	@CrossOrigin
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse (@PathVariable String courseId) {
		try
		{
			this.courseSerivice.deleteCourse (Long.parseLong(courseId)); 
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(	Exception e){
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
