package com.springboot.example2.topics;

import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends CrudRepository<Topic, String> {

}
