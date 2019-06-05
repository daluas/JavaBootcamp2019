package com.cegeka.springMVC.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent_orders")
public class RentOrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;

    @Column(name = "id_bike", nullable = false)
    private Integer idBike;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    public RentOrderEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdBike() {
        return idBike;
    }

    public void setIdBike(Integer idBike) {
        this.idBike = idBike;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
