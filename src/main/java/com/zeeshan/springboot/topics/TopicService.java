package com.zeeshan.springboot.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	List<Topic> topics = new ArrayList<>( Arrays.asList(new Topic("CS101", "Java Spring", "Spring Framework"),
			new Topic("CS102", "JavaScript NodeJS", "Express Framework"),
			new Topic("CS103", "Python Django", "Django Framework")
			));
	
	List<Topic> getAllTopics() {
//		return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopicById(String id) {
		return topics.stream().filter(t -> t.getCourseId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void removeTopic(String id) {
		this.topics.removeIf(t -> t.getCourseId().equals(id));
	}

	public Topic updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getCourseId().equals(id)) {
				topics.set(i, topic);
			}
		}
		return topic;
	}
}
