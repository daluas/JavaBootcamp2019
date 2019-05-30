package com.cegeka.micro.service;

import com.cegeka.micro.model.Headlight;

public interface ComponentService {

    Headlight getHeadlight(String culoare, String luminozitate, String alimentare);
}
