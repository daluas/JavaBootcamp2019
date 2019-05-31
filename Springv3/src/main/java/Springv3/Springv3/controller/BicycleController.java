package Springv3.Springv3.controller;

import Springv3.Springv3.model.Bicycle;
import Springv3.Springv3.service.BicycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BicycleController {

    @Autowired
    BicycleServiceImpl bicycleServiceImpl;

    @RequestMapping(value = "/bicycles", method = RequestMethod.GET)
    ResponseEntity<List<Bicycle>> getAllGames() {
        List<Bicycle> games = bicycleServiceImpl.getAllBicycles();
        if (!games.isEmpty())
            return new ResponseEntity<>(games, HttpStatus.FOUND);
        return new ResponseEntity<>(games, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/bicycles/{id}", method = RequestMethod.GET)
    ResponseEntity<Bicycle> getGameById(@PathVariable Integer id) {
        Optional<Bicycle> bicycle =  bicycleServiceImpl.getBicycleById(id);
        if(bicycle.isPresent())
            return new ResponseEntity<>(bicycle.get(), HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value="/bicycles", method = RequestMethod.POST)
    ResponseEntity addBicycle(@RequestBody Bicycle bicycle) {
        if (bicycle.equals(null)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        Boolean outcome = bicycleServiceImpl.addBicycle(bicycle);
        if (outcome) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity((HttpStatus.NOT_FOUND));
    }
    @RequestMapping(value="bicycles/{id}", method = RequestMethod.DELETE)
    ResponseEntity deleteByid(@PathVariable Integer id){
        Boolean outcome = bicycleServiceImpl.deleteByid(id);
        if(outcome)
            return new ResponseEntity(HttpStatus.FOUND);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value="bicycles/{id}", method = RequestMethod.PUT)
    ResponseEntity updateByid(@PathVariable Integer id, @RequestBody Bicycle bicycle){
        Boolean outcome = bicycleServiceImpl.updateById(id, bicycle);
        if(outcome)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }
}
