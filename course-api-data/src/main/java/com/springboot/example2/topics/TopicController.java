package com.springboot.example2.topics;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController{
	
	//Populated service bean
	@Autowired
	private TopicService topicService;
	
	//Get request Mapping method to send all resources
	@RequestMapping("/topics")
	public List<Topic> getAlltopics(){
		return topicService.getAllTopics();
	}
	
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		
		Optional<Topic> t=topicService.getTopic(id);
		return t.get();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PATCH,value="/topics/{id}")
	public void updateParticularPortionOfTopic(@RequestBody Map<String,Object> fields,@PathVariable String id) {
		
		topicService.updateParticularTopic(fields,id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		
		topicService.deleteTopic(id);
	}
}
