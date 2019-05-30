package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.model.Headlight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value="components", url = "http://localhost:8181/components")
public interface ComponentFeignClient {

    @GetMapping(value = "/aparatoare", produces=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Headlight> getHeadlight(@RequestParam(value = "culoare") String culoare,
                                           @RequestParam(value = "luminozitate") String luminozitate,
                                           @RequestParam(value = "alimentare") String alimentare);
}
