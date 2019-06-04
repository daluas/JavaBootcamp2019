package com.cegeka.springMVC.entity;

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

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name= "buybicycles")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BuyBicycleEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="bb_id", unique = true, nullable = false)
    private Integer id;

    @Column(name="bb_name", nullable = false, length = 40)
    private String name;

    @Column(name="bb_type", length = 40)
    private String type;

    @Column(name="bb_size", length = 1)
    private String size;

    @Column(name="bb_price", nullable = false, precision=6, scale=2)
    private Float price;

    @Column(name="bb_colour", length=20)
    private String colour;

    @Column(name="bb_brand", nullable = false, length=30)
    private String brand;

    @Column(name="bb_quantity", nullable = false, precision=3)
    private Integer quality;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "accessories_bicycles",
            joinColumns = { @JoinColumn(name = "bb_id") },
            inverseJoinColumns = { @JoinColumn(name = "acc_id") }
    )
    List<AccessoryEntity> accessoryEntityList;

    public BuyBicycleEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyBicycleEntity that = (BuyBicycleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(size, that.size) &&
                Objects.equals(price, that.price) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(quality, that.quality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, type, size, price, colour, brand, quality);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
