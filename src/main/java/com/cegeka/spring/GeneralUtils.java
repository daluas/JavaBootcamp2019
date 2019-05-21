package com.cegeka.spring;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GeneralUtils {

    public <T> void print(T t, Function<T, String> function) {
        String string = function.apply(t);
        System.out.println(string);
    }
}
