package com.example.Project1;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GeneralUtils {

    public <T> void print(T t, Function<T, String> function){
        String resultString = function.apply(t);

        System.out.println(resultString);
    }
}