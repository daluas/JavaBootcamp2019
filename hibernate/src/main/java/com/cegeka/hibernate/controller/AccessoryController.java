package com.cegeka.hibernate.controller;

import com.cegeka.hibernate.dto.AccessoryDto;
import com.cegeka.hibernate.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    ResponseEntity<List<AccessoryDto>> getAllGames() {
        List<AccessoryDto> games = accessoryService.getAllAccessories();
        if (!games.isEmpty())
            return new ResponseEntity<>(games, HttpStatus.FOUND);
        return new ResponseEntity<>(games, HttpStatus.NOT_FOUND);
    }
}
