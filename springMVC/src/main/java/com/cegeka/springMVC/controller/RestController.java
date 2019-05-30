package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.model.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/getCompany")
    public String getCompany() {
        return new Company("Cegeka", "Iasi").toString();
    }

    @GetMapping("/testParameter")
    public String testParameter(@RequestParam(value="name", defaultValue = "param") String name) {
        return "Parameter is: " + name;
    }
}
