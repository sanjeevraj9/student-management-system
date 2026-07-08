package com.sms.repository;

import com.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByStudentCode(String studentCode);

    Optional<Student> findByStudentCodeAndDateOfBirth(String studentCode, LocalDate dateOfBirth);
    List<Student> findByNameContainingIgnoreCase(String name);
    @Query("""
       SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId """)
    List<Student> findStudentsByCourseId(@Param("courseId") Long courseId);



}
