package com.cegeka.spring.address.dto;

public class AddressDto {
    private String country;
    private String city;
    private String street;
    private int number;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public AddressDto(String country, String city, String street, int number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;

    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
