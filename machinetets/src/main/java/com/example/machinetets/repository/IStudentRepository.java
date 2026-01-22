package com.example.machinetets.repository;

import com.example.machinetets.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
