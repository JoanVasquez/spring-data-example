package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guirdian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private IStudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder().firstName("Joan").lastName("Vasquez").emailId("test@test.com").build();
		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian() {
		Guirdian guirdian = Guirdian.builder().name("test guardian").email("guardiantest@test.com").mobile("8294568866")
				.build();
		Student student = Student.builder().firstName("Joan").lastName("Vasquez").emailId("test2@test.com")
				.guardian(guirdian).build();

		studentRepository.save(student);
	}

	@Test
	public void listStudents() {
		List<Student> students = studentRepository.findAll();

		System.out.println(students);
	}

	@Test
	public void printStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("Joan");
		System.out.println(students);
	}

	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = studentRepository.findByFirstNameContaining("Joan");
		System.out.println(students);
	}

	@Test
	public void printStudentByLastName() {
		List<Student> students = studentRepository.findByLastNameNotNull();
		System.out.println(students);
	}

	@Test
	public void printStudentsByGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("test guardian");
		System.out.println(students);
	}

	@Test
	public void printStudentsByFirstNameAndLastName() {
		Student students = studentRepository.findByFirstNameAndLastName("Joan", "Vasquez");
		System.out.println(students);
	}

	@Test
	public void printStudentsByEmailAddress() {
		Student students = studentRepository.getStudentByEmailAddress("test@test.com");
		System.out.println(students);
	}

	@Test
	public void printStudentsByEmailAddressNative() {
		Student students = studentRepository.getStudentByEmailAddressNative("test@test.com");
		System.out.println(students);
	}

	@Test
	public void printStudentsByEmailAddressNativeParam() {
		Student students = studentRepository.getStudentByEmailAddressNativeParam("test@test.com");
		System.out.println(students);
	}

	@Test
	public void updateStudentNameByEmailId() {
		studentRepository.updateStudentNameByEmailId("Joan Manuel", "test@test.com");
	}

}
