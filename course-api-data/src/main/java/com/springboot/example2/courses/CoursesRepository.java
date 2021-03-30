package com.springboot.example2.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends CrudRepository<Course, String> {

	public List<Course> findByTopicId(String topicid);
}
