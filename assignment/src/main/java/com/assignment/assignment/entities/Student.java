package com.assignment.assignment.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Student implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "st_fk", referencedColumnName = "id")
    private List<Subject> subject;

    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_fk", referencedColumnName = "id")
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Role role) {
		this.roles.add(role);
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return authorities;

    }

    @Override
    public String getPassword() {
       
        return null;
    }

    @Override
    public String getUsername() {
    
        return null;
    }

}
