package Springv3.Springv3.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Bicycle {

    private Integer id;
    private String name;
    private BicycleType type;
    private BicycleSize size;
    private Double price;
    private BicycleColour colour;
    private String producer;

    public Bicycle() {
    }

    public Bicycle(Integer id, String name, BicycleType type, BicycleSize size, Double price, BicycleColour colour, String producer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.colour = colour;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BicycleType getType() {
        return type;
    }

    public BicycleSize getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public BicycleColour getColour() {
        return colour;
    }

    public String getProducer() {
        return producer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(BicycleType type) {
        this.type = type;
    }

    public void setSize(BicycleSize size) {
        this.size = size;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setColour(BicycleColour colour) {
        this.colour = colour;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
