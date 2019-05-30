package com.example.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class BicyclesRESTController {

    @Autowired
    @Qualifier("bicycleShopService")
    private BicycleService bicycleService;

    @GetMapping(value = "/bicycles",produces = "application/json")
    public ResponseEntity<List<Bicycle>> getListOfBicycles(){

        return new ResponseEntity<>(bicycleService.getListOfBicycles(),HttpStatus.OK);
    }

    @GetMapping(value = "/bicycle{id}",produces = "application/json")
    public ResponseEntity<Bicycle> getBicycleById(@RequestParam("id") Integer bicycleId){

        Bicycle searchedBicycle = Optional.ofNullable(bicycleId)
                .map(bicycleService::getBicycleById)
                .orElse(null);

        if(searchedBicycle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchedBicycle,HttpStatus.OK);

    }

    @GetMapping(value = "/bicyclesByIds{id}",produces = "application/json")
    public ResponseEntity<List<Bicycle>> getBicyclesByIds(@RequestParam("id") List<String> bicyclesStringIds){

        List<Bicycle> listOfSearchedBicycles = Optional.ofNullable(bicyclesStringIds)
                .map(bicycleService::getBicycleByIds)
                .orElse(null);

        if(listOfSearchedBicycles == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listOfSearchedBicycles,HttpStatus.OK);
    }

    @GetMapping(value = "/bicyclesUnderPrice{price}",produces = "application/json")
    public ResponseEntity<List<Bicycle>> getBicyclesWithLowerPrice(@RequestParam("price") Integer bicyclePrice){

        List<Bicycle> listOfSearchedBicycles = Optional.ofNullable(bicyclePrice)
                .map(bicycleService::getBicyclesWithLowerPrice)
                .orElse(null);

        if(listOfSearchedBicycles == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listOfSearchedBicycles,HttpStatus.OK);

    }

    @GetMapping(value = "/bicyclesByType",produces = "application/json")
    public ResponseEntity<Map<BicycleType,List<Bicycle>>> getBicyclesGroupByBicycleType(){

        return new ResponseEntity<>(bicycleService.getBicycleGroupByBicycleType(),HttpStatus.OK);
    }

    @GetMapping(value = "/bicyclesByWheelsType",produces = "application/json")
    public ResponseEntity<Map<BicycleWheelsType,List<Bicycle>>> getBicyclesGroupByBicycleWheelsType(){

        return new ResponseEntity<>(bicycleService.getBicycleGroupByBicycleWheelsType(),HttpStatus.OK);
    }

    @PostMapping(value = "/bicycles",produces = "application/json")
    public ResponseEntity<String> addBicycle(@RequestBody Bicycle bicycle) {

        boolean bicycleaWasAdded = Optional.ofNullable(bicycle)
                .map(bicycleService::addBicycleIfNotExist)
                .orElse(false);

        if(bicycleaWasAdded){
            return new ResponseEntity<>("New Bicycle Added",HttpStatus.OK);
        }
        return new ResponseEntity<>("Bicycle Already Exist",HttpStatus.OK);
    }

    @DeleteMapping(value = "/bicycles",produces = "application/json")
    public ResponseEntity<HttpStatus> deleteAllBicycles(){

        bicycleService.deleteAllBicycles();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/bicycleDeleteById{id}",produces = "application/json")
    public ResponseEntity<String> deleteBicycle(@RequestParam("id") Integer bicycleId){

        boolean bicycleWasDeleted = Optional.ofNullable(bicycleId)
                .map(bicycleService::deleteBicycleById)
                .orElse(false);

        if(bicycleWasDeleted){
            return new ResponseEntity<>("The Bicycle was deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Bicycle doesn't exists",HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/bicycles",produces = "application/json")
    public ResponseEntity<String> updateBicycle(@RequestBody Bicycle bicycle){

        boolean bicycleWasUpdated = Optional.ofNullable(bicycle)
                .map(bicycleService::updateBicycle)
                .orElse(false);

        if(bicycleWasUpdated){
            return new ResponseEntity<>("Bicycle update succesfully",HttpStatus.OK);
        }

        return new ResponseEntity<>("Bicycle was not found",HttpStatus.NOT_FOUND);

    }

    @PatchMapping(value = "/bicycles",produces = "application/json")
    public ResponseEntity<String> updateComponentOfBicycle(@RequestParam("id") Integer bicycleId, @RequestBody Map<Object,Object> bicycleFields) {

       Bicycle searchedBicycle = Optional.ofNullable(bicycleId)
               .map(bicycleService::getBicycleById)
               .orElse(null);

       if(searchedBicycle == null){
           return new ResponseEntity<>("Bicycle not found",HttpStatus.NOT_FOUND);
       }
       searchedBicycle.changeBicycleComponents(bicycleFields);
       return new ResponseEntity<>("Bicycle components Updated",HttpStatus.OK);

    }








}
