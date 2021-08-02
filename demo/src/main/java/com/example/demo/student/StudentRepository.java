package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// The data access layer
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // Transforms into an SQL: SELECT * FROM student WHERE eamil = ?
    // Or we can annotate as:
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
