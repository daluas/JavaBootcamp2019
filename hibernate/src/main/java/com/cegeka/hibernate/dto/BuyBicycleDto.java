package com.cegeka.hibernate.dto;

import com.cegeka.hibernate.model.Accessories;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class BuyBicycleDto {

        private Integer id;
        private String name;
        private String type;
        private String size;
        private Float price;
        private String colour;
        private String brand;
        private Integer quality;
        private List<Accessories> accessories;

        public BuyBicycleDto() {
        }

        public BuyBicycleDto(Integer id, String name, String type, String size, Float price, String colour, String brand, Integer quality, List<Accessories> accessories) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.size = size;
            this.price = price;
            this.colour = colour;
            this.brand = brand;
            this.quality = quality;
            this.accessories = accessories;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Integer getQuality() {
            return quality;
        }

        public void setQuality(Integer quality) {
            this.quality = quality;
        }

        public List<Accessories> getAccessories() {
            return accessories;
        }

        public void setAccessories(List<Accessories> accessories) {
            this.accessories = accessories;
        }
}
