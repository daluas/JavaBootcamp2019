package com.example.SpringMVC;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MySpringApplication {

    @GetMapping("/bicycle")
    @ResponseBody
    public String getId(@RequestParam(name="id")String myId){

        System.out.println(myId);
        return myId;
    }


    @GetMapping("/bicycle/manyId")
    @ResponseBody
    public List<String> getIds(@RequestParam()List<String> id){

        System.out.println(id);
        return id;
    }


    @GetMapping("/bicycle/default")
    @ResponseBody
    public String getIdDefault(@RequestParam(defaultValue = "O valoare default")String id){

        System.out.println(id);
        return id;
    }

    @GetMapping("/bicycle/requiredFalse")
    @ResponseBody
    public String getIdFalseRequired(@RequestParam(required = false)String id){

        System.out.println(id);
        return id;
    }

    @GetMapping("/bicycle/map")
    @ResponseBody
    public Map<String,String> getIds(@RequestParam() Map<String,String> id){

        System.out.println(id);
        return id;
    }

    @GetMapping("/bicycle/{unique}")
    @ResponseBody
    public String getUniqueString(@PathVariable() String unique){

        System.out.println(unique);
        return unique;
    }

    @PostMapping("/bicycle/postId")
    @ResponseBody
    public String getPostId(@RequestBody() String id){
        System.out.println(id);
        return id;
    }


    @DeleteMapping("/bicycle/deleteId")
    @ResponseBody
    public String getDeleteId(@RequestBody() String id){
        System.out.println(id);
        return id;
    }


}
