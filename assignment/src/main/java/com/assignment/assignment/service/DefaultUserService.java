package com.assignment.assignment.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.assignment.assignment.entities.Student;
import com.assignment.assignment.entities.UserDTO;

public interface DefaultUserService extends UserDetailsService{


    Student save(UserDTO Student);
}
