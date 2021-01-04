package com.zeeshan.springboot.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		Topic topic = topicService.getTopicById(id);
		return topic;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		return topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void removeTopic(@PathVariable String id) {
		topicService.removeTopic(id);
	}

}
