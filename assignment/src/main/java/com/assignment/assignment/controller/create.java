package com.assignment.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.Repository.Studentrepo;
import com.assignment.assignment.Repository.Subjectrepo;
import com.assignment.assignment.entities.Student;
import com.assignment.assignment.entities.Subject;

@RestController
@RequestMapping("/assignment")
public class create {

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Subjectrepo subjectrepo;

    @GetMapping("/user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student) {

        studentrepo.save(student);

    }

    @PostMapping("/createSubject")
    public void createSubject(@RequestBody Subject subject) {

        subjectrepo.save(subject);

    }

    @GetMapping("/getStudent")
    public List<Student> getallStudent() {
        return studentrepo.findAll();
    }

    @GetMapping("/getSubject")
    public List<Subject> getallSubject() {
        return subjectrepo.findAll();
    }

}
