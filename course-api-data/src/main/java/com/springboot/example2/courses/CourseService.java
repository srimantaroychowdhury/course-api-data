package com.springboot.example2.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CoursesRepository coursesRepository;
	
	public List<Course> getAllCourses(String topicid){
		List<Course> lst=new ArrayList<>();
		coursesRepository.findByTopicId(topicid).forEach(lst::add);
		return lst;
	}
	
	public Course getCourse(String id) {
		
		return coursesRepository.findById(id).get();
		
	}
	
	public void addCourse(Course course) {
		coursesRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		coursesRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		coursesRepository.deleteById(id);
	}
	
	

}
