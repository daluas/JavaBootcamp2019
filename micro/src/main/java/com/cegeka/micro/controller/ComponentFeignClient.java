package com.cegeka.micro.controller;

import com.cegeka.micro.model.Headlight;
import org.springframework.http.ResponseEntity;

public interface ComponentFeignClient {

    ResponseEntity<Headlight> getHeadlight(String culoare, String luminozitate, String alimentare);
}
