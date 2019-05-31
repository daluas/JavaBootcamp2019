package com.springMVC.Exercise2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("students")
public class MVCcontroller {
    Student student = new Student();
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Student getStudentInJSON(@PathVariable String name) {
        student.setName(name);
        student.setEmail("student@gmail.com");
        return student;
    }
    @RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody Student getStudentInXML(@PathVariable String name) {
        student.setName(name);
        student.setEmail("student@gmail.com");
        return student;
    }
}