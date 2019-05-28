package com.cegeka.springMVC.model;

public class Company {

    private String name;
    private String city;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Company(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
