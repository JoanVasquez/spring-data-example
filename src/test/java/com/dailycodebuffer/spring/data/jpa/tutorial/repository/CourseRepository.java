package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
class CourseRepository {

	@Autowired
	private ICourseRepository repository;

	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("test teacher").lastName("teast teacher").build();
		Course course = Course.builder().title("test title").credit(5).teacher(teacher).build();
		repository.save(course);
	}

	@Test
	public void printCourses() {
		List<Course> courses = repository.findAll();
		System.out.println(courses);
	}

	@Test
	public void findAllPagination() {
		// Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courses = repository.findAll(secondPageWithTwoRecords).getContent();
		long totalElements = repository.findAll(secondPageWithTwoRecords).getTotalElements();
		long totalPages = repository.findAll(secondPageWithTwoRecords).getTotalPages();

		System.out.println(totalPages);
		System.out.println(totalElements);
		System.out.println(courses);
	}

	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		List<Course> courses = repository.findAll(sortByTitle).getContent();

		System.out.println("courses = " + courses);

	}

	@Test
	public void printfindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);

		List<Course> courses = repository.findByTitleContaining("D", firstPageTenRecords).getContent();
		System.out.println(courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder().firstName("test").lastName("test").build();
		Student student = Student.builder().firstName("test").lastName("").emailId("test@test.com").build();
		Course course = Course.builder().title("AI").credit(6).teacher(teacher).build();
		course.addStudent(student);
		
		repository.save(course);
		
	}

}
