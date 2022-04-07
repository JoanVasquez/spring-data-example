package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
public class TeacherRepository {

	@Autowired
	private ITeacherRepository repository;

	@Test
	public void saveTeacher() {
		//Course course = Course.builder().title("DBA").credit(5).build();
		Teacher teacher = Teacher.builder().firstName("test teacher").lastName("test teacher")//.courses(List.of(course))
				.build();
		repository.save(teacher);
	}

}
