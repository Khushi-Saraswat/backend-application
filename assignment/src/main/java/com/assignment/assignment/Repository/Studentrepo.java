package com.assignment.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.assignment.entities.Student;

public interface Studentrepo extends JpaRepository<Student, Integer> {
    Student findByUserName(String name);
}
