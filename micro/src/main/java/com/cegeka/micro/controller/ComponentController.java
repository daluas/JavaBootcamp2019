package com.cegeka.micro.controller;

import com.cegeka.micro.model.Headlight;
import com.cegeka.micro.model.Mudguard;
import com.cegeka.micro.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentController implements ComponentFeignClient {

    ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @Override
    @GetMapping(value = "/components/aparatoare", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Headlight> getHeadlight(@RequestParam(value="culoare") String culoare,
                                                 @RequestParam(value="luminozitate") String luminozitate,
                                                 @RequestParam(value="alimentare") String alimentare) {

        Headlight headlight = componentService.getHeadlight(culoare,luminozitate,alimentare);
        return new ResponseEntity<>(headlight,HttpStatus.OK);
    }
}
