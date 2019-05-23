package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GeneralUtilsComponent {

    public  <T> String print(Function<T,String> functionToApply,T elem){

       return functionToApply.apply(elem);
    }
}
