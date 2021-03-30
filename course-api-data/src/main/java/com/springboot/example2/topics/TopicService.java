package com.springboot.example2.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicsRepository topicsRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> lst=new ArrayList<>();
		topicsRepository.findAll().forEach(lst::add);
		return lst;
	}
	
	public Optional<Topic> getTopic(String id) {
		
		return topicsRepository.findById(id);
		
	}	
	public void addTopic(Topic topic) {
		topicsRepository.save(topic);
	}
	
	public void updateParticularTopic(Map<String,Object> fields, String id) {
		
	}
	public void updateTopic(Topic topic,String id) {
		topicsRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicsRepository.deleteById(id);
	}
	
	

}
