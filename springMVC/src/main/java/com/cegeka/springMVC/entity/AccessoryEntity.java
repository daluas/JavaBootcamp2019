package com.cegeka.springMVC.entity;

/*
acc_id        SERIAL PRIMARY KEY,
    acc_name      varchar(30) NOT NULL,
    acc_price     numeric(6,2) NOT NULL,
    acc_type      varchar(30) NOT NULL,
    acc_quantity    numeric(3) NOT NULL
 */

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="accessories")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccessoryEntity {

    @Id
    @GeneratedValue
    @Column(name="acc_id", unique = true, nullable = false)
    private Integer id;

    @Column(name="acc_name", nullable = false, length = 30)
    private String name;

    @Column(name="acc_price", nullable = false, precision=6, scale=2)
    private Float price;

    @Column(name="acc_type", nullable = false, length = 30)
    private String type;

    @Column(name="acc_quantity", nullable = false, precision=3)
    private Integer quantity;

    @ManyToMany(mappedBy = "accessoryEntityList")
    private List<BuyBicycleEntity> buyBicycleEntities;

    public AccessoryEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessoryEntity that = (AccessoryEntity) o;
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

    public List<BuyBicycleEntity> getBuyBicycleEntities() {
        return buyBicycleEntities;
    }

    public void setBuyBicycleEntities(List<BuyBicycleEntity> buyBicycleEntities) {
        this.buyBicycleEntities = buyBicycleEntities;
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
