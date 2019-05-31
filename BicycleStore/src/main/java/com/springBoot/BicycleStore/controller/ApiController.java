package com.springBoot.BicycleStore.controller;


import com.springBoot.BicycleStore.model.Bicycle;
import com.springBoot.BicycleStore.service.BicycleService;
import com.springBoot.BicycleStore.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    BicycleService bicycleService;

    // -------------------get all bicycles---------------------------------------------

    @RequestMapping(value = "/bicycle", method = RequestMethod.GET)
    public ResponseEntity<List<Bicycle>> listAllBicycles() {
        List<Bicycle> bicycles = bicycleService.findAllBicycles();
        if (bicycles.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bicycle>>(bicycles, HttpStatus.OK);
    }
    // -------------------get single bicycle------------------------------------------

    @RequestMapping(value = "/bicycle/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBicycle(@PathVariable("id") long id) {
        Bicycle bicycle = bicycleService.findById(id);
        if (bicycle == null) {
            return new ResponseEntity(new ErrorType("Bicycle with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bicycle>(bicycle, HttpStatus.OK);
    }
    // -------------------create a bicycle-------------------------------------------

    @RequestMapping(value = "/bicycle/", method = RequestMethod.POST)
    public ResponseEntity<?> createBicycle(@RequestBody Bicycle bicycle, UriComponentsBuilder ucBuilder) {

        if (bicycleService.isBicycleExist(bicycle)) {
            return new ResponseEntity(new ErrorType("Unable to create a bicycle with name " +
                    bicycle.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        bicycleService.saveBicycle(bicycle);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/bicycle/{id}").buildAndExpand(bicycle.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    // ------------------- update a bicycle ------------------------------------------------

    @RequestMapping(value = "/bicycle/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBicycle(@PathVariable("id") long id, @RequestBody Bicycle bicycle) {

        Bicycle currentBicycle = bicycleService.findById(id);

        if (currentBicycle == null) {
            return new ResponseEntity(new ErrorType("Unable to update bicycle with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentBicycle.setName(bicycle.getName());
        currentBicycle.setPrice(bicycle.getPrice());

        bicycleService.updateBicycle(currentBicycle);
        return new ResponseEntity<Bicycle>(currentBicycle, HttpStatus.OK);
    }
    // ------------------- delete a bicycle-----------------------------------------

    @RequestMapping(value = "/bicycle/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBicycle(@PathVariable("id") long id) {

        Bicycle bicycle = bicycleService.findById(id);
        if (bicycle == null) {
            return new ResponseEntity(new ErrorType("Unable to delete bicycle with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        bicycleService.deleteBicycleById(id);
        return new ResponseEntity<Bicycle>(HttpStatus.NO_CONTENT);
    }
    // ------------------- delete all bicycles-----------------------------

    @RequestMapping(value = "/bicycle/", method = RequestMethod.DELETE)
    public ResponseEntity<Bicycle> deleteAllBicycles() {

        bicycleService.deleteAllBicycles();
        return new ResponseEntity<Bicycle>(HttpStatus.NO_CONTENT);
    }






}
