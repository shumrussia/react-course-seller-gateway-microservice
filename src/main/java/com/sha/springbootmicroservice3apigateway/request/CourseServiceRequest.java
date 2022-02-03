package com.sha.springbootmicroservice3apigateway.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="course-service",
			path = "/api/course",
//			url = "${course.service.url}",
			configuration = FeignConfiguration.class)

public interface CourseServiceRequest {

	@PostMapping
	Object saveCourse(@RequestBody Object requestBody);
	
	@DeleteMapping("{courseId}")
	void deleteCourse(@PathVariable("courseId") Long courseId);
	
	@GetMapping
	List<Object> getAllCourses();
}
