package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String firstName);

	public List<Student> findByLastNameNotNull();

	public List<Student> findByGuardianName(String guardianName);

	public Student findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL
	@Query("SELECT S FROM Student S WHERE S.emailId = ?1")
	public Student getStudentByEmailAddress(String emailId);

	@Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
	public Student getStudentByEmailAddressNative(String emailId);

	@Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId", nativeQuery = true)
	public Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
	public int updateStudentNameByEmailId(String firstName, String emailId);

}
