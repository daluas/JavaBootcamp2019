package com.cegeka.micro.service;

import com.cegeka.micro.model.Headlight;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Override
    public Headlight getHeadlight(String culoare, String luminozitate, String alimentare) {
        Random rand = new Random();
        Float pret = rand.nextFloat();
        return new Headlight(culoare, luminozitate,alimentare,pret);
    }
}
