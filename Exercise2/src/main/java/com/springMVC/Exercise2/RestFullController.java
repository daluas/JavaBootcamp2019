package com.springMVC.Exercise2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class RestFullController {
    Student student = new Student();
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public Student getStudentInJSON(@PathVariable String name) {
        student.setName(name);
        student.setEmail("student@yahoo.com");
        return student;
    }
    @RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
    public Student getStudentInXML(@PathVariable String name) {
        student.setName(name);
        student.setEmail("student@yahoo.com");
        return student;
    }
}