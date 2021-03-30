package com.springboot.example2.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example2.topics.Topic;

@RestController
public class CourseController{
	
	//Populated service bean
	@Autowired
	private CourseService courseService;
	
	//Get request Mapping method to send all resources
	@RequestMapping(method=RequestMethod.GET,value="/topics/{topicid}/courses}")
	public List<Course> getAllCourses(@PathVariable String topicid){
		return courseService.getAllCourses(topicid);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/topics/{topicid}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicid}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicid) {
		course.setTopic(new Topic(topicid,",",","));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicid}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicid, @PathVariable String id) {
		course.setTopic(new Topic(topicid,",",","));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		
		courseService.deleteCourse(id);
	}
}
