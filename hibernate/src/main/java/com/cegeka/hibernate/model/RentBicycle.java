package com.cegeka.hibernate.model;

import java.util.Objects;

/*
 rb_id          SERIAL PRIMARY KEY,
    rb_name        varchar(40) NOT NULL,
    rb_type        varchar(10),
    rb_size        varchar(1),
    rb_price       numeric(6,2) NOT NULL,
    rb_colour      varchar(20),
    rb_brand       varchar(20) NOT NULL,
    rb_quantity    numeric(3) NOT NULL

 */

public class RentBicycle {
        private Integer id;
        private String name;
        private String size;
        private Float price;
        private String colour;
        private String brand;
        private Integer quality;

        public RentBicycle() {
        }

        public RentBicycle(Integer id, String name, String size, Float price, String colour, String brand, Integer quality) {
            this.id = id;
            this.name = name;
            this.size = size;
            this.price = price;
            this.colour = colour;
            this.brand = brand;
            this.quality = quality;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.cegeka.hibernate.model.RentBicycle that = (com.cegeka.hibernate.model.RentBicycle) o;
            return Objects.equals(id, that.id) &&
                    Objects.equals(name, that.name) &&
                    Objects.equals(size, that.size) &&
                    Objects.equals(price, that.price) &&
                    Objects.equals(colour, that.colour) &&
                    Objects.equals(brand, that.brand) &&
                    Objects.equals(quality, that.quality);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, name, size, price, colour, brand, quality);
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
    }
