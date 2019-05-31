package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.entity.BicycleToBuyEntity;
import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.model.Bicycle;
import com.cegeka.springMVC.model.Headlight;
import com.cegeka.springMVC.service.BicycleService;
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

    @GetMapping(value = "/bicyclestorent")
    public ResponseEntity<List<BicycleToRentEntity>> getAllBicyclesToRent() {
        //TODO
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycletorent/{id}")
    public ResponseEntity<Optional<BicycleToRentEntity>> getBicycleToRentById(@PathVariable long id) {
        //TODO
        return new ResponseEntity(new BicycleToRentEntity(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycletorent/{name}")
    public ResponseEntity<List<BicycleToRentEntity>> getBicycleToRentByName(@PathVariable String name) {
        //TODO
        return new ResponseEntity(new BicycleToRentEntity(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycletorent/{model}")
    public ResponseEntity<List<BicycleToRentEntity>> getBicycleToRentByModel(@PathVariable String model) {
        //TODO
        return new ResponseEntity(new BicycleToRentEntity(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycletobuy/{id}")
    public ResponseEntity<Optional<BicycleToBuyEntity>> getBicycleToBuyById(@PathVariable long id) {
        //TODO
        return new ResponseEntity(new BicycleToBuyEntity(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycletobuy/{name}")
    public ResponseEntity<List<BicycleToBuyEntity>> getBicycleToBuyByName(@PathVariable String name) {
        //TODO
        return new ResponseEntity(new BicycleToBuyEntity(), HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/bicycletobuy/{model}")
    public ResponseEntity<List<BicycleToBuyEntity>> getBicycleToBuyByModel(@PathVariable String name) {
        //TODO
        return new ResponseEntity(new BicycleToBuyEntity(), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/bicycletorent")
    public ResponseEntity postBicycleToRent(@RequestBody BicycleToRentEntity bicycleToRent) {
        //TODO
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/bicycletobuy")
    public ResponseEntity postBicycleToBuy(@RequestBody BicycleToBuyEntity bicycleToBuy) {
        //TODO
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "bicycletorent/{id}")
    public ResponseEntity deleteBicycleToRent(@PathVariable long id) {
        //TODO
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "bicycletobuy/{id}")
    public ResponseEntity deleteBicycleToBuy(@PathVariable long id) {
        //TODO
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
