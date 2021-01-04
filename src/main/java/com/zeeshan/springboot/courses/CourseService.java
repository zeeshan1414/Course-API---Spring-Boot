package com.zeeshan.springboot.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zeeshan.springboot.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicCourseId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourseById(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void removeCourse(String id) {
		courseRepository.deleteById(id);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
}
