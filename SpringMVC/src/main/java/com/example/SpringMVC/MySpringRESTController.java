package com.example.SpringMVC;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MySpringRESTController {

    @GetMapping("/books")
    public String getId(@RequestParam(name="id")String myId){

        System.out.println(myId);
        return myId;
    }


    @GetMapping("/books/manyId")
    public List<String> getIds(@RequestParam()List<String> id){

        System.out.println(id);
        return id;
    }


    @GetMapping("/books/default")
    public String getIdDefault(@RequestParam(defaultValue = "O valoare default")String id){

        System.out.println(id);
        return id;
    }

    @GetMapping("/books/requiredFalse")
    public String getIdFalseRequired(@RequestParam(required = false)String id){

        System.out.println(id);
        return id;
    }

    @GetMapping(value = "/books/map")
    public Map<String,String> getIds(@RequestParam() Map<String,String> id){

        System.out.println(id);
        return id;
    }

    @GetMapping("/books/{unique}")
    public String getUniqueString(@PathVariable() String unique){

        System.out.println(unique);
        return unique;
    }

    @PostMapping("/books/postId")
    public String getPostId(@RequestBody() String id){
        System.out.println(id);
        return id;
    }


    @DeleteMapping("/books/deleteId")
    public String getDeleteId(@RequestBody() String id){
        System.out.println(id);
        return id;
    }

}
