package com.cegeka.hibernate.model;

/*
acc_id        SERIAL PRIMARY KEY,
    acc_name      varchar(30) NOT NULL,
    acc_price     numeric(6,2) NOT NULL,
    acc_type      varchar(30) NOT NULL,
    acc_quantity    numeric(3) NOT NULL
 */

import java.util.Objects;

public class Accessories {
    private Integer id;
    private String name;
    private Float price;
    private String type;
    private Integer quantity;

    public Accessories() {
    }

    public Accessories(Integer id, String name, Float price, String type, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessories that = (Accessories) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(type, that.type) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, type, quantity);
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
