package com.cegeka.springMVC.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bikes_to_buy")
public class BicycleToBuyEntity implements Serializable {

    private static final long serialVersionUID = -3296315484797323613L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "amount", nullable = false)
    private int amount;

    public BicycleToBuyEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
