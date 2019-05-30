package com.example.SpringMVC;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;

import static com.example.SpringMVC.BicycleWheelsType.*;

@JsonSerialize
public class Bicycle {
    private static int counter;
    private static Random rand = new Random(47);
    private int id = counter++;
    private String name;
    private Double price;
    private String stikerText;
    private BicycleType bicycleType;
    private BicycleWheelsType bicycleWheelsType;

    public Bicycle(){}

    public Bicycle(String name, BicycleType bicycleType) {
        this.name = name;
        this.price = rand.nextDouble()*1000;
        this.bicycleType = bicycleType;
        this.bicycleWheelsType = NORMAL;
    }

    public Bicycle customizeSticker(String stickerText){
        this.stikerText = stickerText;
        return this;
    }

    public Bicycle customizeWheels(BicycleWheelsType bicycleWheelsType){
        this.bicycleWheelsType = bicycleWheelsType;
        return this;
    }

    public void changeBicycleComponents(Map<Object,Object> bicycleFields){
        bicycleFields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Bicycle.class, key.toString());
            field.setAccessible(true);
            ReflectionUtils.setField(field, this , value);
            field.setAccessible(false);
        });
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getStikerText() {
        return stikerText;
    }

    public BicycleType getBicycleType() {
        return bicycleType;
    }

    public BicycleWheelsType getBicycleWheelsType() {
        return bicycleWheelsType;
    }

    @Override
    public String toString(){
        return "Bicycle " + id +" "+ name + ", "+ bicycleType + " ,costs " + price + " and has " + bicycleWheelsType + " wheels";
    }
}
