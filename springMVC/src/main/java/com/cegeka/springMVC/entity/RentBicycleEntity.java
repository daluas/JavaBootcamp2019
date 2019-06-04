package com.cegeka.springMVC.entity;

import javax.persistence.*;
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

@Entity
@Table(name= "rentbicycles")
public class RentBicycleEntity {
    @Id
    @GeneratedValue
    @Column(name="rb_id", unique = true, nullable = false)
    private Integer id;

    @Column(name="rb_name", nullable = false, length = 40)
    private String name;

    @Column(name="rb_type", length = 40)
    private String type;

    @Column(name="rb_size", length = 1)
    private String size;

    @Column(name="rb_price", nullable = false, precision=6, scale=2)
    private Float price;

    @Column(name="rb_colour", length=20)
    private String colour;

    @Column(name="rb_brand", nullable = false, length=30)
    private String brand;

    @Column(name="rb_quantity", nullable = false, precision=3)
    private Integer quality;

        public RentBicycleEntity() {
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentBicycleEntity that = (RentBicycleEntity) o;
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
