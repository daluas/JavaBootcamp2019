package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.entity.BicycleToBuyEntity;
import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.model.BicycleToBuy;
import com.cegeka.springMVC.model.Headlight;
import com.cegeka.springMVC.service.BicycleToBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BicycleToBuyController {

    private BicycleToBuyService bicycleService;
    private ComponentFeignClient componentFeignClient;

    @Autowired
    public BicycleToBuyController(BicycleToBuyService bicycleService, ComponentFeignClient componentFeignClient) {
        this.bicycleService = bicycleService;
        this.componentFeignClient = componentFeignClient;
    }

    @GetMapping(value = "/bicycles/headlight")
    public ResponseEntity<Headlight> getCustomBicycle(@RequestParam(value="culoare") String culoare,
                                                      @RequestParam(value="luminozitate") String luminozitate,
                                                      @RequestParam(value="alimentare") String alimentare) {
        ResponseEntity<Headlight> response = componentFeignClient.getHeadlight(culoare, luminozitate, alimentare);
        Headlight headlight = response.getBody();
        return new ResponseEntity<>(headlight, HttpStatus.OK);
    }

    @GetMapping(value = "/bicyclestobuy")
    public ResponseEntity<List<BicycleToBuy>> getAllBicyclesToBuy() {
        List<BicycleToBuy> bicycleToBuyList =  bicycleService.getAllBicycles();
        return handleBicycleToBuyListResponse(bicycleToBuyList);
    }

    @GetMapping(value = "/bicyclestobuy/{id}")
    public ResponseEntity<Optional<BicycleToBuy>> getBicycleToBuyById(@PathVariable Long id) {
        Optional<BicycleToBuy> bicycleToBuy =  bicycleService.getBicycleById(id);
        if(bicycleToBuy.isPresent()) {
            return new ResponseEntity<>(bicycleToBuy, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicyclestobuy", params = {"name"})
    public ResponseEntity<List<BicycleToBuy>> getBicycleToBuyByName(@RequestParam("name") String name) {
        List<BicycleToBuy> bicycleToBuyList = bicycleService.getBicyclesByName(name);
        return handleBicycleToBuyListResponse(bicycleToBuyList);
    }

    @PostMapping(value = "/bicyclestobuy")
    public ResponseEntity<BicycleToBuyEntity> postBicycleToBuy(@RequestBody BicycleToBuyEntity bicycleToBuyEntity) {
        bicycleService.addBicycle(bicycleToBuyEntity);
        return new ResponseEntity<>(bicycleToBuyEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "bicycletobuy/{id}")
    public ResponseEntity deleteBicycleToBuy(@PathVariable Long id) {
        Integer deletedEntities = bicycleService.deleteBicycleToBuy(id);
        if(deletedEntities == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    private ResponseEntity<List<BicycleToBuy>> handleBicycleToBuyListResponse(List<BicycleToBuy> bicycleList) {
        if (bicycleList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bicycleList, HttpStatus.OK);
    }

//    @GetMapping(value = "/bicyclestorent")
//    public ResponseEntity<List<BicycleToRentEntity>> getAllBicyclesToRent() {
//        //TODO
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/bicycletorent/{id}")
//    public ResponseEntity<Optional<BicycleToRentEntity>> getBicycleToRentById(@PathVariable long id) {
//        //TODO
//        return new ResponseEntity(new BicycleToRentEntity(), HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/bicycletorent/{name}")
//    public ResponseEntity<List<BicycleToRentEntity>> getBicycleToRentByName(@PathVariable String name) {
//        //TODO
//        return new ResponseEntity(new BicycleToRentEntity(), HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/bicycletorent/{model}")
//    public ResponseEntity<List<BicycleToRentEntity>> getBicycleToRentByModel(@PathVariable String model) {
//        //TODO
//        return new ResponseEntity(new BicycleToRentEntity(), HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping(value = "/bicycletorent")
//    public ResponseEntity postBicycleToRent(@RequestBody BicycleToRentEntity bicycleToRent) {
//        //TODO
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping(value = "bicycletorent/{id}")
//    public ResponseEntity deleteBicycleToRent(@PathVariable long id) {
//        //TODO
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }

}
