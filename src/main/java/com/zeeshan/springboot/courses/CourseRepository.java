package com.zeeshan.springboot.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    public List<Course> findByTopicCourseId(String topicId);

}
