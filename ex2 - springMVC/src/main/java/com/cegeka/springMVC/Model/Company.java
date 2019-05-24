package com.cegeka.springMVC.Model;

public class Company {

    String name;
    String city;

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
