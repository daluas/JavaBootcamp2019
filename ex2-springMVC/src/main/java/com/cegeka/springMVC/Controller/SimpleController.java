package com.cegeka.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    private String textToShow = "This is my first spring app!";

    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("textToShow", textToShow);
        return "home";
    }

    @GetMapping(value = "/simpleResponse")
    public @ResponseBody String getSimpleResponse() {
        return "<h1>Simple Response</h1>";
    }

    @GetMapping(value = "/simpleResponse/{id}")
    public @ResponseBody String getById(@PathVariable int id) {
        return "<h1>Simple Response using id: " + id + "</h1>";
    }

}
