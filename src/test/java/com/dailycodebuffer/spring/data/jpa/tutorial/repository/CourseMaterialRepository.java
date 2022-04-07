package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialTest {

	@Autowired
	private ICourseMaterialRepository repository;

	public void saveCourseMaterial() {
		Course course = Course.builder().title("test course").credit(1).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.test.com").course(course).build();
		repository.save(courseMaterial);
	}

	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterials = repository.findAll();
		System.out.println(courseMaterials);
	}

}
