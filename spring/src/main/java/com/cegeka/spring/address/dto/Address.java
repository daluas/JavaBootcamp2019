package com.cegeka.spring.address.dto;

public class Address {
    private String city;
    private String street;
    private Integer number;

    public Address(String country, String city, String street, Integer number ){
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "City: " + this.city
                + ", street: " + this.street + ", number: " + this.number;
    }
}
