package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.entity.RentOrderEntity;
import com.cegeka.springMVC.service.RentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/rentorders")
public class RentOrdersController {

    private RentOrderService rentOrderService;

    @Autowired
    public RentOrdersController(RentOrderService rentOrderService) {
        this.rentOrderService = rentOrderService;
    }

    @PostMapping
    public ResponseEntity<RentOrderEntity> postRentOrder(@RequestBody RentOrderEntity rentOrderEntity) {
        if(rentOrderEntity == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        boolean isAdded = rentOrderService.addRentOrder(rentOrderEntity);
        if(!isAdded) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(rentOrderEntity, HttpStatus.CREATED);
    }

}
