package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.model.Bicycle;
import com.cegeka.springMVC.model.Headlight;
import com.cegeka.springMVC.service.BicycleService;
import com.cegeka.springMVC.service.impl.BicycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BicycleController {

    private BicycleService bicycleService;
    private ComponentFeignClient componentFeignClient;

    @Autowired
    public BicycleController(BicycleService bicycleService, ComponentFeignClient componentFeignClient) {
        this.bicycleService = bicycleService;
        this.componentFeignClient = componentFeignClient;
    }

    @GetMapping(value = "/bicycle/headlight")
    public ResponseEntity<Headlight> getCustomBicycle(@RequestParam(value="culoare") String culoare,
                                                      @RequestParam(value="luminozitate") String luminozitate,
                                                      @RequestParam(value="alimentare") String alimentare) {
        ResponseEntity<Headlight> response = componentFeignClient.getHeadlight(culoare, luminozitate, alimentare);
        Headlight headlight = response.getBody();
        return new ResponseEntity<>(headlight, HttpStatus.OK);
    }

    @GetMapping(value = "/bicycles")
    public ResponseEntity<List<Bicycle>> getAllBicycles() {
        List<Bicycle> bicycleList = bicycleService.getAllBicycles();
        return handleBicycleListResponse(bicycleList);
    }

    @GetMapping(value = "/bicycle/{id}")
    public ResponseEntity<Optional<Bicycle>> getBicycleById(@PathVariable long id) {
        Optional<Bicycle> bicycle = bicycleService.getBicycleById(id);
        if (bicycle.isPresent()) {
            return new ResponseEntity<>(bicycle, HttpStatus.OK);
        }
        return new ResponseEntity<>(bicycle, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycles/{name}")
    public ResponseEntity<List<Bicycle>> getBicyclesByName(@PathVariable String name) {
        List<Bicycle> bicycleList = bicycleService.getBicycleByName(name);
        return handleBicycleListResponse(bicycleList);
    }

    @PostMapping(value = "/bicycle")
    public ResponseEntity postBicycle(@RequestBody Bicycle bicycle) {
        bicycleService.addBicycle(bicycle);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "bicycle/{id}")
    public ResponseEntity updateBicycle(@PathVariable long id,
                              @RequestBody Bicycle bicycle) {
        BicycleServiceImpl.UpdateStatus responseStatus = bicycleService.updateBicycle(id, bicycle);
        if(responseStatus == BicycleServiceImpl.UpdateStatus.UPDATED) {
            return new ResponseEntity(HttpStatus.OK);
        } else if(responseStatus == BicycleServiceImpl.UpdateStatus.NOT_UPDATED) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "bicycles")
    public ResponseEntity updateAllBicycles() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "bicycle/{id}")
    public ResponseEntity partialUpdateBicycle(@PathVariable long id,
                                               @RequestBody Bicycle bicycle) {
        BicycleServiceImpl.UpdateStatus response = bicycleService.partialUpdateBicycle(id, bicycle);
        if(response == BicycleServiceImpl.UpdateStatus.UPDATED)
            return new ResponseEntity(HttpStatus.OK);
        else if(response == BicycleServiceImpl.UpdateStatus.NOT_UPDATED)
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "bicycles")
    public ResponseEntity partialUpdateAllBicycles() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "bicycle/{id}")
    public ResponseEntity deleteBicycle(@PathVariable long id) {
        if(bicycleService.deleteBicycle(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "bicycles")
    public ResponseEntity deleteAllBicycles() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<List<Bicycle>> handleBicycleListResponse(List<Bicycle> bicycleList) {
        if (bicycleList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bicycleList, HttpStatus.OK);
    }
}
