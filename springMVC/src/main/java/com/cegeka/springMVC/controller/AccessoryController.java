package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.model.Accessory;
import com.cegeka.springMVC.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessoryController {

    AccessoryService accessoryService;

    @Autowired
    public AccessoryController(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    ResponseEntity<List<Accessory>> getAllGames() {
        List<Accessory> games = accessoryService.getAllAccessories();
        if (!games.isEmpty())
            return new ResponseEntity<>(games, HttpStatus.FOUND);
        return new ResponseEntity<>(games, HttpStatus.NOT_FOUND);
    }
}
