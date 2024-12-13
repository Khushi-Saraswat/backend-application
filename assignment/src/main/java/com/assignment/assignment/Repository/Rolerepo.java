package com.assignment.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.assignment.entities.Role;


public interface Rolerepo extends JpaRepository<Role, Integer> {
    
    Role findByRole(String role);
}
