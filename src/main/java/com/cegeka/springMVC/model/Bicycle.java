package com.cegeka.springMVC.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Bicycle {

    private long id;
    private String name;
    private String model;
    private long price;

    public Bicycle() {
    }

    public Bicycle(long id, String name, String model, long price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
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

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
