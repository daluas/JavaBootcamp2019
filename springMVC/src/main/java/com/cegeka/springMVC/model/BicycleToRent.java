package com.cegeka.springMVC.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class BicycleToRent {
    private long id;
    private String name;
    private String model;
    private long pricePerHour;

    public BicycleToRent() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public long getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
