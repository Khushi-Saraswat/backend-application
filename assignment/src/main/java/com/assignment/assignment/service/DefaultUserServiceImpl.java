package com.assignment.assignment.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.assignment.assignment.Repository.Rolerepo;
import com.assignment.assignment.Repository.Studentrepo;
import com.assignment.assignment.entities.Role;
import com.assignment.assignment.entities.Student;
import com.assignment.assignment.entities.UserDTO;

public class DefaultUserServiceImpl implements DefaultUserService{

    @Autowired
    Studentrepo studentrepo;

    @Autowired
    Rolerepo rolerepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentrepo.findByUserName(username);
    return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getAddress(), mapRolesToAuthorities(student.getRoles()));
    }

    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

    @Override
    public Student save(UserDTO student) {
        Role role=new Role();
        if(student.getRole().equals("USER"))
		 role = rolerepo.findByRole("ROLE_USER");
		else if(student.getRole().equals("ADMIN"))
		 role = rolerepo.findByRole("ROLE_ADMIN");
		Student user = new Student();
		
		user.setName(student.getName());
		
		user.setRole(role);
		return studentrepo.save(user);

    }

    
}
